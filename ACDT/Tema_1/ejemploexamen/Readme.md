# Creamos los modelos de objetos que se usaran para serializar la información

# Añadimos las etiquetas @XML necesarias a cada clase y atributo del modelo

    - @XmlRootElement -> Para clase raiz de un documento XML, cuando se desea crear un documento a partir de esta clase
    - @XmlAccessorType(XmlAccessType.FIELD) -> Indica al xml acceder al elemento directamente y no alos getter o setter
    - @XmlElement(required = true) -> Si no se encuentra el elemento al serializar se lanzará una excepción
