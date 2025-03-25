create database virtual_art_gallery;
use virtual_art_gallery;

CREATE TABLE Artists (
    ArtistID INT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Biography TEXT,
    Nationality VARCHAR(100)
);

CREATE TABLE Categories (
    CategoryID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL
);

CREATE TABLE Artworks (
    ArtworkID INT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    ArtistID INT,
    CategoryID INT,
    Year INT,
    Description TEXT,
    ImageURL VARCHAR(255),
    FOREIGN KEY (ArtistID) REFERENCES Artists (ArtistID),
    FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID)
);

CREATE TABLE Exhibitions (
    ExhibitionID INT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    StartDate DATE,
    EndDate DATE,
    Description TEXT
);

CREATE TABLE ExhibitionArtworks (
    ExhibitionID INT,
    ArtworkID INT,
    PRIMARY KEY (ExhibitionID, ArtworkID),
    FOREIGN KEY (ExhibitionID) REFERENCES Exhibitions (ExhibitionID),
    FOREIGN KEY (ArtworkID) REFERENCES Artworks (ArtworkID)
);

DESCRIBE artists;
DESCRIBE artworks;
DESCRIBE categories;