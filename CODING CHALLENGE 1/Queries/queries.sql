

-- 1. Retrieve the names of all artists along with the number of artworks they have in the gallery, and 
-- list them in descending order of the number of artworks. 
select artists.name, count(artworks.ArtworkID) as NumberOfArtworks from artists left join artworks
on artists.ArtistID=artworks.ArtistID group by artists.ArtistID order by NumberOfArtworks desc;

-- 2. List the titles of artworks created by artists from 'Spanish' and 'Dutch' nationalities, and order 
-- them by the year in ascending order. 
select artworks.title from artworks join artists on artists.ArtistID=artworks.ArtistID
where artists.Nationality='Spanish' or artists.Nationality='Dutch'
order by artworks.year asc;

-- 3. Find the names of all artists who have artworks in the 'Painting' category, and the number of 
-- artworks they have in this category. 
select artists.Name, count(artworks.ArtworkID) as NumberOfArtworks from artists join 
artworks on artists.ArtistID=artworks.ArtistID join categories on artworks.categoryID=
categories.CategoryID where categories.name='Painting' group by artists.ArtistID, artworks.ArtistID;

-- 4. List the names of artworks from the 'Modern Art Masterpieces' exhibition, along with their 
-- artists and categories. 
select Artworks.Title as ArtworkTitle, Artists.Name as ArtistName, Categories.Name as CategoryName
from ExhibitionArtworks
join Artworks on ExhibitionArtworks.ArtworkID = Artworks.ArtworkID
join Artists on Artworks.ArtistID = Artists.ArtistID
join Categories on Artworks.CategoryID = Categories.CategoryID
join Exhibitions on ExhibitionArtworks.ExhibitionID = Exhibitions.ExhibitionID
where Exhibitions.Title = 'Modern Art Masterpieces';

-- 5.Find the artists who have more than two artworks in the gallery. 
select artists.name from artists join artworks on artists.ArtistID=artworks.ArtistID
group by artists.ArtistID having count(artworks.ArtworkID)>2;

-- 6.Find the titles of artworks that were exhibited in both 'Modern Art Masterpieces' and 
-- 'Renaissance Art' exhibitions 
SELECT artworks.Title FROM artworks 
JOIN ExhibitionArtworks ea1 ON artworks.ArtworkID = ea1.ArtworkID
JOIN Exhibitions e1 ON ea1.ExhibitionID = e1.ExhibitionID 
JOIN ExhibitionArtworks ea2 ON artworks.ArtworkID = ea2.ArtworkID
JOIN Exhibitions e2 ON ea2.ExhibitionID = e2.ExhibitionID
WHERE e1.Title = 'Modern Art Masterpieces' AND e2.Title = 'Renaissance Art';

-- 7.Find the total number of artworks in each category
select categories.Name as CategoryName, COUNT(artworks.ArtworkID) as NumberOfArtworks
from categories left join artworks on categories.CategoryID = artworks.CategoryID
group by categories.CategoryID, categories.Name;

-- 8.List artists who have more than 3 artworks in the gallery.
select artists.Name from artists join artworks on artists.ArtistID = artworks.ArtistID 
group by artists.ArtistID, artists.Name 
having count(artworks.ArtworkID) > 3;

-- 9.Find the artworks created by artists from a specific nationality (e.g., Spanish).
select artworks.Title from artworks join artists on artworks.ArtistID = artists.ArtistID 
where artists.Nationality = 'Spanish';

-- 10. List exhibitions that feature artwork by both Vincent van Gogh and Leonardo da Vinci. 
select distinct exhibitions.Title 
from exhibitions 
join ExhibitionArtworks on exhibitions.ExhibitionID = ExhibitionArtworks.ExhibitionID 
join artworks on ExhibitionArtworks.ArtworkID = artworks.ArtworkID 
join artists on artworks.ArtistID = artists.ArtistID 
where artists.Name in ('Vincent van Gogh', 'Leonardo da Vinci') 
group by exhibitions.Title 
having COUNT(distinct artists.Name) = 2;

-- 11. Find all the artworks that have not been included in any exhibition.
select artworks.Title 
from artworks left join ExhibitionArtworks on artworks.ArtworkID = ExhibitionArtworks.ArtworkID 
where ExhibitionArtworks.ExhibitionID IS NULL;

-- 12.  List artists who have created artworks in all available categories.
select artists.Name from artists join artworks on artists.ArtistID = artworks.ArtistID 
group by artists.ArtistID, artists.Name 
having COUNT(distinct artworks.CategoryID) = (select COUNT(*) from categories);

-- 13.  List the total number of artworks in each category. 
select categories.Name as CategoryName, COUNT(artworks.ArtworkID) as NumberOfArtworks 
from categories left join artworks on categories.CategoryID = artworks.CategoryID 
group by categories.CategoryID, categories.Name;

-- 14. Find the artists who have more than 2 artworks in the gallery.
select artists.Name from artists join artworks on artists.ArtistID = artworks.ArtistID 
group by artists.ArtistID, artists.Name having COUNT(artworks.ArtworkID) > 2;

-- 15. List the categories with the average year of artworks they contain, only for categories with more 
-- than 1 artwork.
select categories.Name as CategoryName, avg(artworks.Year) as AverageYear 
from categories join artworks on categories.CategoryID = artworks.CategoryID 
group by categories.CategoryID, categories.Name 
having COUNT(artworks.ArtworkID) > 1;

-- 16.Find the artworks that were exhibited in the 'Modern Art Masterpieces' exhibition.
select artworks.Title from artworks join ExhibitionArtworks on artworks.ArtworkID = ExhibitionArtworks.ArtworkID 
join exhibitions ON ExhibitionArtworks.ExhibitionID = exhibitions.ExhibitionID 
where exhibitions.Title = 'Modern Art Masterpieces';

-- 17. Find the categories where the average year of artworks is greater than the average year of all 
-- artworks.
select categories.Name as CategoryName 
from categories 
join artworks on categories.CategoryID = artworks.CategoryID 
group by categories.CategoryID, categories.Name 
having avg(artworks.Year) > (select avg(Year) from artworks);

-- 18.List the artworks that were not exhibited in any exhibition. 
select artworks.Title 
from artworks left join ExhibitionArtworks ON artworks.ArtworkID = ExhibitionArtworks.ArtworkID 
where ExhibitionArtworks.ExhibitionID is null;

-- 19.Show artists who have artworks in the same category as "Mona Lisa." 
select distinct artists.Name from artists 
join artworks on artists.ArtistID = artworks.ArtistID 
where artworks.CategoryID = (select CategoryID from artworks where Title = 'Mona Lisa');

-- 20. List the names of artists and the number of artworks they have in the gallery.
select artists.Name, COUNT(artworks.ArtworkID) as NumberOfArtworks 
from artists left join artworks on artists.ArtistID = artworks.ArtistID 
group by artists.ArtistID, artists.Name;





