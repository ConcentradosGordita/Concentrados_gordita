
package modelo;

/**
 *
 * @author kamt
 */
public class Categoria {
 
    
    private String id_categoria;
    private String descripcion_categoria;

    public Categoria(String id_categoria, String descripcion_categoria) {
        this.id_categoria = id_categoria;
        this.descripcion_categoria = descripcion_categoria;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public Categoria() {
    }

    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + ", descripcion_categoria=" + descripcion_categoria + '}';
    }
    
    
}
