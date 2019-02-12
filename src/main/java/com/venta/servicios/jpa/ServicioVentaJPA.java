package com.venta.servicios.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.venta.servicios.ServicioVenta;

@Service
public class ServicioVentaJPA implements ServicioVenta {
	@Autowired
	private ProductoRepository repoproducto;
	@Autowired
	private CategoriaRepository repocategoria;
	@Autowired
	private ClienteRepository repocliente;
	@Autowired
	private DocumentoRepository repodocumento;
	@Autowired
	private UserRepository repouser;
	@Autowired
	private FacturaRepository repofactura;

	public ProductoRepository getRepoproducto() {
		return repoproducto;
	}

	public void setRepoproducto(ProductoRepository repoproducto) {
		this.repoproducto = repoproducto;
	}

	public CategoriaRepository getRepocategoria() {
		return repocategoria;
	}

	public void setRepocategoria(CategoriaRepository repocategoria) {
		this.repocategoria = repocategoria;
	}

	public ClienteRepository getRepocliente() {
		return repocliente;
	}

	public void setRepocliente(ClienteRepository repocliente) {
		this.repocliente = repocliente;
	}

	public DocumentoRepository getRepodocumento() {
		return repodocumento;
	}

	public void setRepodocumento(DocumentoRepository repodocumento) {
		this.repodocumento = repodocumento;
	}

	public UserRepository getRepouser() {
		return repouser;
	}

	public void setRepouser(UserRepository repouser) {
		this.repouser = repouser;
	}
	
	public FacturaRepository getRepofactura() {
		return repofactura;
	}

	public void setRepofactura(FacturaRepository repofactura) {
		this.repofactura = repofactura;
	}

	public Producto findOneProd(Integer id) {
		return repoproducto.findOne(id);
	}

	public Iterable<Producto> findAllProd() {
		return repoproducto.findAll();
	}

	@Transactional
	public void saveProd(Producto producto) {
		repoproducto.save(producto);
	}

	@Transactional
	public void updateProd(Producto producto) {
		Producto p = repoproducto.findOne(producto.getId());
		p.setNombre(producto.getNombre());
		p.setStock(producto.getStock());
		p.setPrecio(producto.getPrecio());
		p.setCategoria(producto.getCategoria());
		repoproducto.save(p);
	}

	@Transactional
	public void deleteProd(Producto producto) {
		repoproducto.delete(producto);
	}

	public Categoria findOneCat(Integer id) {
		return repocategoria.findOne(id);
	}

	public Iterable<Categoria> findAllCat() {
		return repocategoria.findAll();
	}

	@Transactional
	public void saveCat(Categoria categoria) {
		repocategoria.save(categoria);
	}

	@Transactional
	public void updateCat(Categoria categoria) {
		Categoria c = repocategoria.findOne(categoria.getId());
		c.setDenominacion(categoria.getDenominacion());
		repocategoria.save(c);
	}

	@Transactional
	public void deleteCat(Categoria categoria) {
		Categoria c = repocategoria.findOne(categoria.getId());
		c.setBorrado(false);
		repocategoria.save(c);
	}

	public Cliente findOneCli(Integer id) {
		return repocliente.findOne(id);
	}

	public Iterable<Cliente> findAllCli() {
		return repocliente.findAll();
	}

	@Transactional
	public void saveCli(Cliente cliente) {
		repocliente.save(cliente);
	}

	@Transactional
	public void updateCli(Cliente cliente) {
		Cliente c = repocliente.findOne(cliente.getId());
		c.setDni(cliente.getDni());
		c.setNombres(cliente.getNombres());
		c.setApellidos(cliente.getApellidos());
		c.setDireccion(cliente.getDireccion());
		repocliente.save(c);
	}

	@Transactional
	public void deleteCli(Cliente cliente) {
		repocliente.delete(cliente);
	}

	public Documento findOneDoc(Integer id) {
		return repodocumento.findOne(id);
	}

	public Iterable<Documento> findAllDoc() {
		return repodocumento.findAll();
	}

	@Transactional
	public void saveDoc(Documento documento) {
		repodocumento.save(documento);
	}

	@Transactional
	public void updateDoc(Documento documento) {
		Documento d = repodocumento.findOne(documento.getId());
		d.setNombre(documento.getNombre());
		repodocumento.save(d);
	}

	@Transactional
	public void deleteDoc(Documento documento) {
		Documento d = repodocumento.findOne(documento.getId());
		d.setBorrado(false);
		repodocumento.save(d);
	}

	public User findOneUser(Integer id) {
		return repouser.findOne(id);
	}

	@Transactional
	public Iterable<User> findAllUser() {
		return repouser.findAll();
	}

	@Transactional
	public void saveUser(User user) {
		repouser.save(user);
	}

	@Transactional
	public void updateUser(User user) {
		User u = repouser.findOne(user.getId());
		u.setNombres(user.getNombres());
		u.setApellidos(user.getApellidos());
		u.setDni(user.getDni());
		u.setEmail(user.getEmail());
		u.setUsername(user.getUsername());
		repouser.save(u);
	}

	@Transactional
	public void deleteUser(User user) {
		repouser.delete(user);
	}
	
	public Factura findOneFac(Integer id) {
        return repofactura.findOne(id);
    }

    public Iterable<Factura> findAllFac() {
        return repofactura.findAll();
    }

    @Transactional
    public void saveFac(Factura factura) {
        repofactura.save(factura);
    }

    @Transactional
    public void updateFac(Factura factura) {
        Factura f = repofactura.findOne(factura.getId());
        f.setEstado(factura.getEstado());
        f.setCliente(factura.getCliente());
        f.setDocumento(factura.getDocumento());
        repofactura.save(f);
    }

    @Transactional
    public void deleteFac(Factura factura) {
        repofactura.delete(factura);
    }

}
