package com.venta.test;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

import com.venta.proy.Categoria;
import com.venta.proy.Cliente;
import com.venta.proy.Factura;
import com.venta.proy.Producto;

public class AddTest extends JPAUnitTest {

	@Test
	public void entityManagerFactoryOK() {
		assertNotNull(emf);
	}

	@Test
	public void insertar() {
		em.getTransaction().begin();
		Cliente cl1 = new Cliente(1, "Sergio", "Carranza", "Las flores nro 8956", "45788956");
		Cliente cl2 = new Cliente(2, "Cristiam", "Torres", "Las flores nro 8956", "45788957");
		Cliente cl3 = new Cliente(3, "Jose", "Ocho", "Las flores nro 8956", "45788958");
		Cliente cl4 = new Cliente(4, "Elmer", "Chavez", "Las flores nro 8956", "45788959");
		em.persist(cl1);
		em.persist(cl2);
		em.persist(cl3);
		em.persist(cl4);
		em.getTransaction().commit();

		em.getTransaction().begin();
		Categoria ncat = new Categoria(1, "Categoria 1");
		Categoria ncat1 = new Categoria(2, "Categoria 2");
		Categoria ncat3 = new Categoria(3, "Categoria 3");
		Categoria ncat4 = new Categoria(4, "Categoria 4");
		Categoria ncat5 = new Categoria(5, "Categoria 5");

		em.persist(ncat);
		em.persist(ncat1);
		em.persist(ncat3);
		em.persist(ncat4);
		em.persist(ncat5);
		em.getTransaction().commit();

		Categoria c = em.find(Categoria.class, 1);
		Categoria c1 = em.find(Categoria.class, 2);

		em.getTransaction().begin();
		Producto p = new Producto("Chedar", 100, 20, c);
		Producto p1 = new Producto("Coca Cola", 200, 30, c1);
		Producto p3 = new Producto("Inka Cola", 150, 35, c1);
		em.persist(p);
		em.persist(p1);
		em.persist(p3);
		em.getTransaction().commit();

		// Factura
		Cliente cli1 = em.find(Cliente.class, 1);
		Cliente cli2 = em.find(Cliente.class, 2);
		em.getTransaction().begin();
		Date dt = new Date();
		Date dt2 = new Date();
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-12");
			dt2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Factura f1 = new Factura("F001", dt, 1, cli1);
		Factura f2 = new Factura("F002", dt, 1, cli1);
		Factura f3 = new Factura("F003", dt, 1, cli1);
		Factura f4 = new Factura("F004", dt2, 1, cli2);
		Factura f5 = new Factura("F005", dt2, 1, cli2);
		em.persist(f1);
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);
		em.persist(f5);
		em.getTransaction().commit();

//		Detalle

	}

}
