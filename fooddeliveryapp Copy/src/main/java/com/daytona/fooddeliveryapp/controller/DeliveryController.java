package com.daytona.fooddeliveryapp.controller;
import com.daytona.fooddeliveryapp.dto.CustomerResponse;
import com.daytona.fooddeliveryapp.entity.CustomerDAO;
import com.daytona.fooddeliveryapp.entity.MenuDAO;
import com.daytona.fooddeliveryapp.entity.OrderDAO;
import com.daytona.fooddeliveryapp.entity.RestaurantDAO;
import com.daytona.fooddeliveryapp.service.CustomerService;
import com.daytona.fooddeliveryapp.service.MenuService;
import com.daytona.fooddeliveryapp.service.OrderService;
import com.daytona.fooddeliveryapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    // Customer APIs
    @PostMapping("/customer")
    public CustomerDAO registerCustomer(@RequestBody CustomerDAO customerDAO) {
        return customerService.registerCustomer(customerDAO);
    }
    @GetMapping("/customer/{id}")
    public CustomerDAO getCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }
//    @GetMapping("/allcustomers")
//    public List<CustomerDAO> getAllCustomer(){
//        return customerService.getAllCustomer();
//    }
    @GetMapping("/allcustomers")
    public ResponseEntity<List<CustomerResponse>>getAllCustomer(){
        return new ResponseEntity<List<CustomerResponse>>(customerService.getAllCustomer(), HttpStatusCode.valueOf(1));
    }



    @DeleteMapping("customer/{id}")
    public CustomerDAO deleteCustomerById(@PathVariable Long id){
//        Customer tempCustomer=customerService.findCustomerById(id);
//        if(tempCustomer==null){
//            throw new RuntimeException("Customer not found - "+id);
//        }
        return customerService.deleteCustomerById(id);
    }

    // Restaurant APIs
    @PostMapping("/restaurant")
    public RestaurantDAO saveRestaurant(@RequestBody RestaurantDAO restaurantDAO) {
        return restaurantService.saveRestaurant(restaurantDAO);
    }

    @GetMapping("/restaurant/{id}")
    public RestaurantDAO getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }
    @GetMapping("restaurants")
    public List<RestaurantDAO> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    // Menu APIs
    @PostMapping("/menu")
    public MenuDAO createMenuItem(@RequestBody MenuDAO menuDAOItem) {
        return menuService.createMenuItem(menuDAOItem);
    }

    @GetMapping("/menu/{id}")
    public MenuDAO getMenuItemById(@PathVariable Long id) {
        return menuService.getMenuItemById(id);
    }

    // Order APIs
    @PostMapping("/order")
    public OrderDAO placeOrder(@RequestBody OrderDAO orderDAO) {
        return orderService.placeOrder(orderDAO);
    }

    @GetMapping("/order/{id}")
    public OrderDAO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }


    @GetMapping("/order")
    public List<OrderDAO> getAllOrders() {
        return orderService.getAllOrders();
    }
}
