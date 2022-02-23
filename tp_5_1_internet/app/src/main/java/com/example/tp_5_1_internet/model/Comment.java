package com.example.tp_5_1_internet.model;

import org.json.JSONObject;

/**
 * Complétez cette classe pour correspondre a l'objet renvoyé par l'API /comments.
 */
public class Comment {

    // 1 - Ajoutez les variables d'instance avec le type correspondant

    public Comment(JSONObject jsonObject) {
        // 2 - Initialisez les variables d'instance depuis le JSONObject passé en paramètre
        // Vous pouvez utiliser les méthodes `optInt(...), optString(...), optJSonObject(...) etc.`
        // pour gérer les valeurs par défaut le cas ou la propriété n'est pas présente.
    }

    // 3 - Override la méthode toString() (indice : utilisez `alt + inser`)

    // 4 - Ajouter les méthodes getter/setter (indice : utilisez `alt + inser`)
}

// Exemple d'un objet Comment
// {
//     "postId": 1,
//     "id": 1,
//     "name": "id labore ex et quam laborum",
//     "email": "Eliseo@gardner.biz",
//     "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
// }
