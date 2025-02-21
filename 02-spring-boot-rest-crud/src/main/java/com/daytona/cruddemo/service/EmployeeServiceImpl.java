package com.daytona.cruddemo.service;

import com.daytona.cruddemo.dao.EmployeeDao;
import com.daytona.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeedao;
    private final RedisTemplate<String, String> redisTemplate;
    private final RedisTemplate<String, Object> redisTemplateObject;


    @Override
//    @Cacheable(value = "employeeCache")
    public List<Employee> findAll() {
        return employeedao.findAll();
    }

    @Override
    @Cacheable(value = "employeeCache", key = "#theId", condition = "#theId>5", unless = "#result == null")
    public Employee findById(Long theId) {

        return employeedao.findById(theId);
    }

    @Override
    @Transactional
    // @CacheEvict(value = "employeeCache", allEntries = true)
    public Employee save(Employee theEmployee) {
        var emp = employeedao.save(theEmployee);
        redisTemplateObject.opsForValue().set("emp" + emp.getId(), emp);
        redisTemplateObject.expire("emp", Duration.ofMinutes(20));

        return emp;
    }

    @Override
    @Transactional
    public void deleteById(Long theId) {
        String key = "DELETE_" + theId;
        String value = redisTemplate.opsForValue().get(key);
        redisTemplate.opsForValue().set(key, theId + " ");
        redisTemplate.expire(key, Duration.ofMinutes(10));
        employeedao.deleteById(theId);
//        if (!StringUtils.hasText(value)) {
//            redisTemplate.opsForValue().set(key, theId + "");
//            redisTemplate.expire(key, Duration.ofMinutes(10));
//            employeedao.deleteById(theId);
//        }
//        log.error("Key already present :: {}", value);
    }
}
