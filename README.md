
# GenerateInvoiceSain

Retorna lista de números de teléfono disponible


## Installation

Update target directory (para actualizar las clases autogeneradas por javax.xml)

```bash
  mvn clean package
```

### Run locally

Ubicarse en la carpeta ``/target`` y ejecutar el siguiente comando:
```bash
  java -jar GenerateInvoiceSain-0.0.1-SNAPSHOT.jar
```

El servidor se encontrará corriendo esperando peticiones SOAP

## API Reference

#### WSDL location for test

```http
  GET http://localhost:8080/ws/countries.wsdl
```

| Parameter  | Type     | Description                                                   |
|:-----------|:---------|:--------------------------------------------------------------|
| `name`     | `string` | **Required**. Nombre del pais (BOL por ejemplo)               |
| `population`     | `int`    | **Required**. Numero de población del pais                    |
| `capital`     | `string` | **Required**. Capital del pais (por ejemplo Bolivia -> Sucre) |
| `currency` | `string` | **Required**. Tipo de moneda (EUR, GBP, BOL)                  |



## Authors

- [@skynoor](https://github.com/skynoorz)

