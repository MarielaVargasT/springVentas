package com.venta.servicios;

import com.venta.proy.Categoria;
import com.venta.proy.Cliente;
import com.venta.proy.Documento;
import com.venta.proy.Factura;
import com.venta.proy.Producto;
import com.venta.proy.User;
import com.venta.repositorios.CategoriaRepository;
import com.venta.repositorios.ClienteRepository;
import com.venta.repositorios.DocumentoRepository;
import com.venta.repositorios.FacturaRepository;
import com.venta.repositorios.ProductoRepository;
import com.venta.repositorios.UserRepository;

public interface ServicioVenta {

	ProductoRepository getRepoproducto();

	void setRepoproducto(ProductoRepository repoproducto);

	CategoriaRepository getRepocategoria();

	void setRepocategoria(CategoriaRepository repocategoria);
	
	ClienteRepository getRepocliente();

	void setRepocliente(ClienteRepository repocliente);
	
	DocumentoRepository getRepodocumento();

	void setRepodocumento(DocumentoRepository repodocumento);
	
	UserRepository getRepouser();

	void setRepouser(UserRepository repouser);
	
	FacturaRepository getRepofactura();

	void setRepofactura(FacturaRepository repofactura);

	Producto findOneProd(Integer id);

	Iterable<Producto> findAllProd();

	void saveProd(Producto producto);
	
	void updateProd(Producto producto);

	void deleteProd(Producto producto);

	Categoria findOneCat(Integer id);

	Iterable<Categoria> findAllCat();

	void saveCat(Categoria categoria);
	
	void updateCat(Categoria categoria);

	void deleteCat(Categoria categoria);
	
	Cliente findOneCli(Integer id);

	Iterable<Cliente> findAllCli();

	void saveCli(Cliente cliente);
	
	void updateCli(Cliente cliente);

	void deleteCli(Cliente cliente);
	
	Documento findOneDoc(Integer id);

	Iterable<Documento> findAllDoc();

	void saveDoc(Documento documento);
	
	void updateDoc(Documento documento);

	void deleteDoc(Documento documento);
	
	User findOneUser(Integer id);

	Iterable<User> findAllUser();

	void saveUser(User user);
	
	void updateUser(User user);

	void deleteUser(User user);
	
	Factura findOneFac(Integer id);

	Iterable<Factura> findAllFac();

	void saveFac(Factura factura);
	
	void updateFac(Factura factura);

	void deleteFac(Factura factura);

}