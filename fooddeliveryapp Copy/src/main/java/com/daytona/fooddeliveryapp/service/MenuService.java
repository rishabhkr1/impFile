package com.daytona.fooddeliveryapp.service;
import com.daytona.fooddeliveryapp.repository.MenuRepository;
import com.daytona.fooddeliveryapp.entity.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuItemRepository;

    public MenuDAO createMenuItem(MenuDAO menuDAOItem) {
        return menuItemRepository.save(menuDAOItem);
    }

    public MenuDAO getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }
}
