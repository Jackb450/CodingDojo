SELECT world.languages.
LANGUAGE AS language, world.countries. NAME AS country_name, world.languages.percentage
FROM world.languages
JOIN world.countries ON world.languages.country_id = world.countries.id
WHERE world.languages.LANGUAGE = "Slovene"
ORDER BY world.languages.percentage DESC;

SELECT countries.
NAME AS country_name, COUNT(cities.NAME) AS cities
FROM cities
JOIN countries ON cities.country_id = countries.id
GROUP BY countries.NAME ORDER BY cities DESC;

SELECT cities.NAME, cities.population FROM cities
JOIN countries ON cities.country_id = countries.id
WHERE countries.NAME = "Mexico" AND cities.population > 500000
ORDER BY cities.population DESC;

SELECT countries.
NAME AS country_name, languages.LANGUAGE AS language, languages.percentage
FROM languages
LEFT JOIN countries ON languages.country_id = countries.id
WHERE languages.percentage > 89
ORDER BY languages.percentage DESC;

SELECT countries.
NAME, countries.surface_area, countries.population FROM countries
WHERE countries.surface_area < 501 AND countries.population > 100000;

SELECT countries.
NAME, countries.government_form, countries.capital, countries.life_expectancy
FROM countries
WHERE countries.government_form = 'Constitutional Monarchy' AND	countries.capital > 200 AND countries.life_expectancy > 75;

SELECT countries.
NAME AS country_name, cities.NAME AS city_name, cities.district, cities.population
FROM cities
JOIN countries ON countries.id = cities.country_id
WHERE countries.NAME = 'Argentina' AND cities.district = 'Buenos Aires' AND cities.population > 500000;

SELECT countries.region, COUNT(countries.NAME) AS countries FROM countries
GROUP BY countries.region ORDER BY countries DESC;