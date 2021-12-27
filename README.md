- Abra o projeto com sua IDE favorita
- Entre com as credenciais do banco de dados H2 em application.properties.
- Run ClinicaodontoApplication

Cadastro de pacientes (POST)
http://localhost:8080/patient
```json
{
  "firstName": "Leonardo",
  "lastName": "Santino",
  "rg": "123456789",
  "registrationDate": "27-12-2021"
}
```
Edite um pacientes (PUT)
http://localhost:8080/patient/ "ensira o id do paciente aqui"
```json
{
  "firstName": "Leonardo alterar",
  "lastName": "Santino alterar",
  "rg": "123456789 alterar",
  "registrationDate": "27-12-2021 alterar"
}
```
DELETE um pacientes (DELETE)
http://localhost:8080/patient/ "ensira o id do paciente aqui"

Busque por ID um pacientes (GET)
http://localhost:8080/patient/ "ensira o id do paciente aqui"

Busque todos pacientes (GET)
http://localhost:8080/patient

Rota de Dentistas (POST) (PUT) (DELETE) (GET)
http://localhost:8080/dentist

Rota de Endereço (POST) (PUT) (DELETE) (GET)
http://localhost:8080/address
