package com.example.tp_5_1_internet_kotlin.model

import org.json.JSONObject

/**
 * Complétez cette classe pour correspondre a l'objet renvoyé par l'API /users.
 * Il n'est pas nécessaire de faire des sous classes pour les champs address, geo et company.
 * Vous pouvez les ajouter directement dans l'objet User
 */
class User(private val jsonObject: JSONObject) {

    // 1 - Ajoutez les variables d'instance avec le type correspondant

    // 2 - Initialisez les variables d'instance depuis le JSONObject passé en paramètre
    // Vous pouvez utiliser les méthodes `optInt(...), optString(...), optJSonObject(...) etc.`
    // pour gérer les valeurs par défaut le cas ou la propriété n'est pas présente.

    // 3 - Override la méthode toString() (indice : utilisez `alt + inser`)

}

// Exemple d'un objet User
//{
//        "id": 1,
//        "name": "Leanne Graham",
//        "username": "Bret",
//        "email": "Sincere@april.biz",
//        "address": {
//          "street": "Kulas Light",
//          "suite": "Apt. 556",
//          "city": "Gwenborough",
//          "zipcode": "92998-3874",
//          "geo": {
//              "lat": "-37.3159",
//              "lng": "81.1496"
//          }
//        },
//        "phone": "1-770-736-8031 x56442",
//        "website": "hildegard.org",
//        "company": {
//          "name": "Romaguera-Crona",
//          "catchPhrase": "Multi-layered client-server neural-net",
//          "bs": "harness real-time e-markets"
//        }
//}