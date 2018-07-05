package com.jhonathan.ilustrando.models;

import com.jhonathan.ilustrando.data.dao.ItemDao;
import com.jhonathan.ilustrando.data.entidade.Item;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jhonathan
 */
public class ItemBO {

    @Autowired
    private ItemDao itemDao;

    public List<Item> getlistItem() {
        return itemDao.findAll();
    }

    public Optional<Item> getItem(Integer id) {
        return itemDao.findById(id);
    }

    @Transactional
    public Item setPessoa(Item i) {
        return itemDao.save(i);
    }
}
