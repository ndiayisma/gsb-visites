# GSB Version Android/Gestion de praticiens et visites

## 💊Contexte

Dans le cadre d'un projet de développement débutant de Novembre 2025 à Avril 2026, le but est de réaliser un application mobile avec Android Studio qui permettra aux visiteurs de consulter et voir en détails les visites des praticiens disponibles

## 📱Objectif principal

- **Se connecter via un token qu'on doit le passer via un header Postman**
- **Parcourir les praticiens disponibles**
- **En parcourant un praticien, afficher ses visites et créer ou le mettre à jour**

## 🪛Configuration Système recommandé

- Windows 10/11
- macOS Ventura (Version 13) ou ultérieure
- Version Linux datant d'après 2022
- **16 Go** de Stockage HDD minumum
- **8 Go** de RAM minimum

## 🗃️Architecture utilisés

- Android Studio (utilisé pour le développement mobile) : https://developer.android.com/studio?hl=fr
- Postman (pour récupérer les APIs et les données)
- ExpressJS **(afin de le connecter à l'API)**  : https://nodejs.org/en/download (à le télecharger)
- SQLite (intégré de base à Android Studio

## 📱Architecture d'Android Studios
Activities : chaque écran principal correspond à une Activity
DataBinding : liaison entre les données et les vues
SQLite : stockage local des données utilisateurs (praticiens et visites)

## 🛰️Utilisation de l'interface Retrofit et Services

Grâce à cela, on peut récupérer l'API via un environnement Postman pour appeler un praticien

Exemple :
```bash
@GET("/api/praticiens")
    Call<List<Praticien>> getAllPraticiens();
```


## 📂Arborescence de l'application

- **Modèle** : Ici, les classes tels que Visiteur et Praticiens seront dispo
- **API** : Grâce à cela, nous utiliserons des appels API afin de récupérer les données essentiels pour une Activity

## GSB en Backend/Gerer les API et en faire des appels
Etant lié au répositoire qui permet de gérer les API et classe en TS, cette application a la capacité de récupérer les données API et d'enregistrer la base de Données via un Cluster de MongoDB

### 🚀 Fonctionnalités de l'API
- Gestion des utilisateurs (inscription, connexion)
- CRUD complet sur les rapports de visite
- Authentification par jeton (JWT)
- Sécurisation avancée (chiffrement, protection XSS, limitation de requêtes, middlewares)

### 📈Mode d'emploi pour déployer l'API
1. Clôner le dépôt du repository suivant :
```bash
git clone https://github.com/SIO-LGF/gsb-api-ismail.git
cd backend/src
```
2. Installer les dépendances disponibles
```bash
# Installer les dépendances
npm init -y
npm install
```
3. Démarrer le serveur
```bash
npx ts-node server.ts
```


### Exemples
![Capture d'écran 2025-04-28 203032](https://github.com/user-attachments/assets/65430286-acde-4890-9f29-6a8df8f5690c)

#### Une fois que le visiteur s'est connecté à l'application : 
![Capture d'écran 2025-04-28 212433](https://github.com/user-attachments/assets/ede94c99-1372-4184-9d5b-0f27f4f1cce0)


