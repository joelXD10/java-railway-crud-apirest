package com.joelreinoso.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.joelreinoso.apirest.apirest.Repositories.ProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.joelreinoso.apirest.apirest.Entities.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController  //Anotacion que indica que la clase anotada es un controlador, lo que significa que maneja solicitudes web.
@RequestMapping("/productos")  /* Anotación utilizada para mapear solicitudes web a métodos específicos dentro de una clase de controlador. 
Define qué URL(s) o patrón de URL(s) se asocian con un controlador o un método de controlador, y 
qué acciones deben realizarse cuando se recibe una solicitud en esa URL.*/
public class ProductoController {

    @Autowired  /*Anotación que se utiliza para permitir que Spring resuelva e inyecte las dependencias necesarias en los componentes, 
    como clases de servicio o controladores de froma automatica, sin necesidad de que 
    el programador tenga que instanciarlas manualmente. */
    private ProductoRepository productoRepositorio;

    @GetMapping  //Anotación que se utiliza para mapear solicitudes HTTP GET a métodos específicos dentro de un controlador 
    /*
     *Envia una solicitud HTTP GET que se utiliza para solicitar datos del servidor
     *
     * HTTP GET: Es un método de solicitud HTTP utilizado para recuperar datos de un servidor sin alterar su estado. 
     */
    public List<Producto> obtenerProductos(){
        return productoRepositorio.findAll();  //Retorna y muestra todos los productos del repositorio
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorID(@PathVariable Long id){
        return productoRepositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID " + id));  //Lanza una excepcion en canso de no encontrar el producto por medio del ID
    }

    @PostMapping  //Anotacion que se utiliza para mapear solicitudes HTTP POST a métodos específicos dentro de un controlador.
    /*
     * 
     * HTTP POST: es un método utilizado en el protocolo HTTP para enviar datos al servidor con el propósito de crear o modificar un recurso
     * 
     * @RequestBody : anotacion que se utiliza para vincular el cuerpo de una solicitud HTTP directamente a un objeto Java. Nos
     * permite convertir automáticamente los datos enviados en una solicitud POST, PUT, o PATCH en una instancia de una clase Java.
     */
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepositorio.save(producto);
        
    }
    
    @PutMapping ("/{id}") //Anotacion Se utiliza para mapear solicitudes HTTP PUT a métodos específicos dentro de un controlador
    /*
     * HHTP PUT: es un método del protocolo HTTP que se utiliza para enviar datos al servidor con el propósito de crear 
     * o actualizar un recurso en una ubicación específica
     * 
     * 
     */
     //@PathVariable: se utiliza para extraer valores de la parte de la URL de una solicitud HTTP
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto){
        Producto producto = productoRepositorio.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID " + id));  //Lanza una excepcion en canso de no encontrar el producto por medio del ID
        
        producto.setNombre(detallesProducto.getNombre());  
        producto.setPrecio(detallesProducto.getPrecio());

        return productoRepositorio.save(producto);
    }

    @DeleteMapping("/{id}") //Anootación que se utiliza para mapear solicitudes HTTP DELETE a métodos específicos en un controlador
    /*
     * HTTP DELETE: es uno de los métodos del protocolo HTTP que se utiliza para eliminar un recurso en el servidor
     * 
     */
    public String eliminarProducto(@PathVariable Long id){
        Producto producto = productoRepositorio.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID " + id));  
        productoRepositorio.delete(producto);  //elimina el producto encontrado por medio del ID
        return "El producto con el ID: " + id + " fue eliminado correctamente";        
    }

    //import org.springframework.web.bind.annotation.RequestParam;
     
}
