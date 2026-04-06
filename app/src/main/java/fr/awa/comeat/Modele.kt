package fr.awa.comeat

import java.time.LocalDate

data class SpecialiteCulinaire(
    val id: Int,
    val libelle: String
){
    override fun toString(): String {
        return libelle
    }
}

data class Repas(
    val id: Int,
    val date: LocalDate,
    val nbCouverts: Int,
    val specialite: SpecialiteCulinaire,
    val hote: Utilisateur,
    val convives: MutableList<Utilisateur> = mutableListOf()
){

    fun inscrire( utilisateur: Utilisateur ) {
        convives.add( utilisateur )
    }

    fun getNbPlacesLibres(): Int {
        return nbCouverts - convives.size
    }

    fun encoreDeLaPlace(): Boolean {
        if( nbCouverts > convives.size ){
            return true
        }
        return false
    }

    fun estConvive( idUtilisateur: Int ): Boolean {
        for( convive in convives ){
            if( convive.id == idUtilisateur ){
                return true
            }
        }
        return false
    }

    fun estHote( idUtilisateur: Int ): Boolean {
        if( idUtilisateur == hote.id ){
            return true
        }
        return false
    }
}


object Modele {

    private val specialites: MutableList<SpecialiteCulinaire> = mutableListOf(
        SpecialiteCulinaire( 1 , "Libanais" ) ,
        SpecialiteCulinaire( 2 , "Marocain" ) ,
        SpecialiteCulinaire( 3 , "Grec" ) ,
        SpecialiteCulinaire( 4 , "Espagnol" ) ,
        SpecialiteCulinaire( 5 , "Italien" ) ,
        SpecialiteCulinaire( 6 , "Sénégalais" ) ,
        SpecialiteCulinaire( 7 , "Inuit" ) ,
    )

object Modele

    val utilisateurs: MutableList<Utilisateur> = mutableListOf(
        Utilisateur(1, "alves", "diego", "adieux@gmail.com", "azerty"),
        Utilisateur(2, "ferreira", "armando", "salut@gmail.com", "azerty"),
        Utilisateur(3, "GRIMES", "Rick", "rick.grimes@gmail.com", "azerty"),
        Utilisateur(4, "DIXON", "Daryl", "daryl.dixon@gmail.com", "azerty"),
        Utilisateur(5, "DIXON", "Michonne", "michonne.dixon@gmail.com", "azerty"),
        Utilisateur(6, "RHEE", "Glenn", "glenn.rhee@gmail.com", "azerty"),
        Utilisateur(7, "GREENE", "Maggie", "maggie.greene@gmail.com", "azerty"),
        Utilisateur(8, "GREENE", "Carl", "carl.greene@gmail.com", "azerty"),
        Utilisateur(9, "SMITH", "Andrea", "andrea.smith@gmail.com", "azerty"),
        Utilisateur(10, "SMITH", "Negan", "hegan.smith@gmail.com", "azerty"),
        Utilisateur(11, "PORTER", "Eugène", "eugene.porter@gmail.com", "azerty"),
        Utilisateur(12, "PELETIER", "Carole", "carole.peletier@gmail.com", "azerty"),
        Utilisateur(13, "GREENE", "Beth", "beth.greene@gmail.com", "azerty")
    )
    private val repas: MutableList<Repas> = mutableListOf(
        Repas( 1 , LocalDate.of( 2026 , 4 , 17 ) , 4 , specialites.get( 3 ) , utilisateurs.get( 1 )  ) ,
        Repas( 2 , LocalDate.of( 2026 , 4 , 18 ) , 2 , specialites.get( 0 ) , utilisateurs.get( 0 )  ) ,
        Repas( 3 , LocalDate.of( 2026 , 4 , 19 ) , 2 , specialites.get( 3 ) , utilisateurs.get( 3 )  ) ,
        Repas( 4 , LocalDate.of( 2026 , 4 , 20 ) , 13 , specialites.get( 2 ) , utilisateurs.get( 2 )  ) ,
        Repas( 5 , LocalDate.of( 2026 , 4 , 21 ) , 3 , specialites.get( 1 ) , utilisateurs.get( 1 )  ) ,
        Repas( 6 , LocalDate.of( 2026 , 4 , 21 ) , 4 , specialites.get( 4 ) , utilisateurs.get( 4 )  ) ,
        Repas( 8 , LocalDate.of( 2026 , 4 , 13 ) , 4 , specialites.get( 3 ) , utilisateurs.get( 1 )  ) ,
        Repas( 7 , LocalDate.of( 2026 , 4 , 21 ) , 4 , specialites.get( 5 ) , utilisateurs.get( 1 )  ),
        Repas( 9  , LocalDate.of( 2026 , 4 , 8  ) , 3  , specialites.get( 0 ) , utilisateurs.get( 0 ) ) ,
        Repas( 10 , LocalDate.of( 2026 , 4 , 9  ) , 5  , specialites.get( 0 ) , utilisateurs.get( 2 ) ) ,
        Repas( 11 , LocalDate.of( 2026 , 4 , 10 ) , 4  , specialites.get( 1 ) , utilisateurs.get( 1 ) ) ,
        Repas( 12 , LocalDate.of( 2026 , 4 , 11 ) , 6  , specialites.get( 1 ) , utilisateurs.get( 3 ) ) ,
        Repas( 13 , LocalDate.of( 2026 , 4 , 12 ) , 2  , specialites.get( 2 ) , utilisateurs.get( 0 ) ) ,
        Repas( 14 , LocalDate.of( 2026 , 4 , 14 ) , 8  , specialites.get( 2 ) , utilisateurs.get( 4 ) ) ,
        Repas( 15 , LocalDate.of( 2026 , 4 , 15 ) , 3  , specialites.get( 3 ) , utilisateurs.get( 2 ) ) ,
        Repas( 16 , LocalDate.of( 2026 , 4 , 16 ) , 5  , specialites.get( 4 ) , utilisateurs.get( 1 ) ) ,
        Repas( 17 , LocalDate.of( 2026 , 4 , 22 ) , 4  , specialites.get( 4 ) , utilisateurs.get( 3 ) ) ,
        Repas( 18 , LocalDate.of( 2026 , 4 , 23 ) , 7  , specialites.get( 5 ) , utilisateurs.get( 0 ) ) ,
        Repas( 19 , LocalDate.of( 2026 , 4 , 24 ) , 3  , specialites.get( 5 ) , utilisateurs.get( 4 ) ) ,
        Repas( 20 , LocalDate.of( 2026 , 4 , 25 ) , 6  , specialites.get( 6 ) , utilisateurs.get( 2 ) ) ,
        Repas( 21 , LocalDate.of( 2026 , 4 , 26 ) , 4  , specialites.get( 6 ) , utilisateurs.get( 1 ) ) ,
        Repas( 22 , LocalDate.of( 2026 , 4 , 27 ) , 5  , specialites.get( 0 ) , utilisateurs.get( 3 ) )
    )

    init {

        repas.get(0).inscrire( utilisateurs.get( 12 ) )
        repas.get(0).inscrire( utilisateurs.get( 7 ) )
        repas.get(0).inscrire( utilisateurs.get( 3 ) )

        repas.get(1).inscrire( utilisateurs.get( 10 ) )
        repas.get(1).inscrire( utilisateurs.get( 7 ) )

        repas.get(2).inscrire( utilisateurs.get( 4 ) )

        repas.get(3).inscrire( utilisateurs.get( 5 ) )
    }


    fun findUtilisateur(email: String, mdp: String): Utilisateur? {
        return utilisateurs.find { it.email == email && it.mdp == mdp}
    }

    fun getSpecialites(): MutableList<SpecialiteCulinaire> {
        return specialites
    }

    fun getSesRepas(): MutableList<Repas> {
        return repas
    }
    fun getRepasByDateSpecialite(): MutableList<Repas> {
        return repas
    }
    var utilisateurConnecte: Utilisateur? = null
}