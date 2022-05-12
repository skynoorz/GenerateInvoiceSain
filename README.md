
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

Con endpoint:

```http
  GET http://localhost:8080/ws/generateInvoiceSainRequest.wsdl
```
Sin endpoint aun:

```http
  GET http://localhost:8080/ws/generateInvoiceSainResponse.wsdl
```

```http
  GET http://localhost:8080/ws/parameterTypeV2.wsdl
```

```http
  GET http://localhost:8080/ws/requestHeader.wsdl
```

```http
  GET http://localhost:8080/ws/responseHeaderV3.wsdl
```

## Authors

- [@skynoor](https://github.com/skynoorz)

