package com.maderacnc.MaderaCNC.services;

import java.util.ArrayList;

import com.maderacnc.MaderaCNC.Categoria;

import org.springframework.stereotype.Service;

@Service
public class CategoriaServices {
	
	public final ArrayList<Categoria> category_list = new ArrayList<Categoria>();

	public CategoriaServices () {
		category_list.add(new Categoria("Almacenamiento", "Productos de madera para almacenamiento"));
		category_list.add(new Categoria("Cocina", "Productos de madera para la cocina"));
		category_list.add(new Categoria("Decoración", "Productos de madera para decoración"));
		category_list.add(new Categoria("Varios", "Productos de madera para usos varios"));
	} // constructor
	
	public ArrayList<Categoria> getCategories () {
		return category_list;
	} // getCategories

	public Categoria getCategory (Long id) {
		Categoria tmpCategory = null;
		for (Categoria category : category_list) {
			if (category.getCategory_id() == id) {
				tmpCategory = category;
				break;
			} // if
		} // foreach
		return tmpCategory;
	} // getCategory
	
} // class categoriaServices