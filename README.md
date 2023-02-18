# Product-ms

## Endpoints
- BaseURL: /products
- POST: create()
- GET: getAll()
- GET /{id}: getById()
- PUT /{id}: update()
- DELETE /{id}: delete()

## Model
```json
{
"id": 1,
"name":"iphone 13 Pro Max",
"description": "Celular de ultima geração",
"price": 6999.00,
"available": true
}
```

## Businees Rules
- Só é possível a criação de produtos com preço POSITIVO;
- Não é possível pesquisar produtos que não estão disponíveis;
- Não é possível inserir descrições com menos de 10 caracteres;
- Não é possivel criar um produto com o mesmo nome;
- O nome deve ter entre 3 a 30 caracteres;

# Warehouse-ms

## Endpoints
- BaseURL: /warehouses
- POST: create()
- GET: getAll()
- GET /{id}: *
- PUT /{id}: *
- DELETE /{id}: delete() *

## Model
```json
{
    "id": 1,
    "product-id": 1,
    "quantity": 10
}
```


## Businees Rules
- O estoque é reponsável por avisar se o produto  estáo ou não disponivel.
- Não é permitido mais de uma linha do mesmo produto salvo na base de dados
