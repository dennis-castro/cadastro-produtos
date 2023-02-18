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


