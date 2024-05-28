# Reparatii PC/laptop si vanzare componente
## Descriere
Un service online pentru PC-uri si laptopuri, unde clientii pot vedea pretul serviciilor, pot face programare pentru a stii cand se poate duce dispozitivul la reparat si pot vedea cand acesta este gata de preluare.
De asemenea exista posibilitatea de a comanda componente si accesorii online.

## Actiuni urilizator
- Conectare
- Vizualizare, filtrare, comandare componente
- Creare programare
- Scriere recenzie
- Vizualizare data preluare

## Actiuni admin
- Adaugare, stergere, modificare componente
- Vizualizare, modificare programari
- Scriere data preluare
- Stergere recenzie

## Diagrama bazei de date
![Diagram](diagram/diagram2.png)

## Observer Pattern
![Observer](diagram/observer.png)

## Endpoints
### User
- POST
    - **/addUser**           - salveaza un client
    - **/addUsers**          - salveaza mai multi clienti
- GET
    - **/users**             - cauta toti clientii
    - **/user/{id}**         - cauta clientul care are id-ul dat
    - **/userEmail/{email}** - cauta clientul care are email-ul dat
- PUT 
    - **/updateUser**        - modifica un client 
- DELETE
    - **/deleteUser/{id}**   - sterge clientul care are id-ul dat

### Product
- POST
    - **/addProduct**         - salveaza un produs
    - **/addProducts**        - salveaza mai multe produse
- GET
    - **/products**           - cauta toate produsele
    - **/product/{id}**       - cauta produsul care are id-ul dat
    - **/product/{name}**     - cauta produsul care are numele dat
- PUT
    - **/updateProduct**      - modifica un produs
- DELETE
    - **/deleteProduct/{id}** - sterge produsul care are id-ul dat

### Order
- POST
    - **/addOrder**         - salveaza o comanda
    - **/addOrders**        - salveaza mai multe comenzi
- GET
    - **/orders**           - cauta toate comanzile
    - **/order/{id}**       - cauta comanda care are id-ul dat
- PUT
    - **/updateOrder**      - modifica o comanda
- DELETE
    - **/deleteOrder/{id}** - sterge comanda care are id-ul dat

### Ordered Product
- POST
    - **/addOrderedProduct**         - salveaza un produs comandat
    - **/addOrderedProducts**        - salveaza mai multe produse comandate
- GET
    - **/orderedProducts**           - cauta toate produsele comandate
    - **/orderedProduct/{id}**       - cauta produsul comandat care are id-ul dat
- PUT
    - **/updateOrderedProduct**      - modifica un produs comandat
- DELETE
    - **/deleteOrderedProduct/{id}** - sterge produsul comandat care are id-ul dat

### Review
- POST
    - **/addReview**         - salveaza o recenzie
    - **/addReviews**        - salveaza mai multe recenzii
- GET
    - **/reviews**           - cauta toate recenziile
    - **/review/{id}**       - cauta recenzia care are id-ul dat
- PUT
    - **/updateReview**      - modifica o recenzie
- DELETE
    - **/deleteReview/{id}** - sterge recenzia care are id-ul dat
    
### Appointment
- POST
    - **/addAppointment**         - salveaza o programare
    - **/addAppointments**        - salveaza mai multe programari
- GET
    - **/appointments**           - cauta toate programarile
    - **/appointment/{id}**       - cauta programarea care are id-ul dat
- PUT
    - **/updateAppointment**      - modifica o programare
- DELETE
    - **/deleteAppointment/{id}** - sterge programarea care are id-ul dat


## Diagrama de clase
![Diagram](diagram/classDiagram.png)

## Diagrama use-case
![Diagram](diagram/useCase.png)

## Frontend
Partea de frontend este realizata in React. 

