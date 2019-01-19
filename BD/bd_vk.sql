-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Янв 19 2019 г., 19:14
-- Версия сервера: 10.1.30-MariaDB
-- Версия PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `bd_vk`
--

-- --------------------------------------------------------

--
-- Структура таблицы `background`
--

CREATE TABLE `background` (
  `id` int(11) NOT NULL,
  `background` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `background`
--

INSERT INTO `background` (`id`, `background`) VALUES
(1, 'background1');

-- --------------------------------------------------------

--
-- Структура таблицы `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `title` varchar(120) NOT NULL,
  `zanr` varchar(45) NOT NULL,
  `opis` varchar(10000) DEFAULT '',
  `rok` varchar(11) DEFAULT '',
  `jezyk` varchar(45) DEFAULT '',
  `ocena_imdb` double NOT NULL,
  `czas_trwania` varchar(11) DEFAULT '',
  `obsada` varchar(45) DEFAULT '',
  `dost` varchar(4) NOT NULL DEFAULT 'tak',
  `rezerwacja` varchar(4) DEFAULT 'nie',
  `rezerwacja_id` varchar(8) DEFAULT '',
  `czas_rezerwacji` datetime DEFAULT NULL,
  `ostatni_wyn` varchar(11) DEFAULT '',
  `ostatnia_data_wyn` varchar(20) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `film`
--

INSERT INTO `film` (`id`, `title`, `zanr`, `opis`, `rok`, `jezyk`, `ocena_imdb`, `czas_trwania`, `obsada`, `dost`, `rezerwacja`, `rezerwacja_id`, `czas_rezerwacji`, `ostatni_wyn`, `ostatnia_data_wyn`) VALUES
(4, 'The Good, the Bad and the Ugly', 'Western', 'A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.', '1966', 'English', 8.9, '178', 'Eli Wallach,Clint Eastwood,Lee Van Cleef', 'da', 'ne', '6AI3RS', '2017-06-22 15:31:31', '6AI3RS', '22 06 2017'),
(5, 'The Shawshank Redemption', 'Crime, Drama ', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', '1994', 'English', 9.3, '144', 'Tim Robbins, Morgan Freeman, Bob Gunton', 'da', 'da', '6AI3RS', '2017-09-10 13:18:12', '', '20 06 2017'),
(6, 'Star Wars: Episode V - The Empire Strikes Back', 'Action, Adventure, Fantasy ', 'After the rebels are overpowered by the Empire on their newly established base, Luke Skywalker begins Jedi training with Master Yoda. His friends accept shelter from a questionable ally as Darth Vader hunts them in a plan to capture Luke.', '1980', 'English', 8.8, '124', 'Mark Hamill, Harrison Ford, Carrie Fisher', 'da', 'ne', '', '2017-06-08 00:00:00', '6AI3RS', '22 06 2017'),
(7, 'Fight Club', 'Drama', 'An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soap maker, forming an underground fight club that evolves into something much, much more.', '1999', 'English', 8.8, '139', 'Brad Pitt, Edward Norton, Meat Loaf', 'da', 'ne', '', '2017-06-15 00:00:00', '', ''),
(11, 'The Lord of the Rings: The Return of the King ', 'Adventure, Drama, Fantasy ', 'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle Earth from the Dark Lord Sauron.', '2003', 'English', 8.9, '201', 'Elijah Wood, Viggo Mortensen, Ian McKellen', 'da', 'ne', '', '2017-06-09 00:00:00', 'UVOWEC', '19 01 2019'),
(15, 'The Transporter', 'Action, Crime, Thriller', 'Frank is hired to \"transport\" packages for unknown clients and has made a very good living doing so. But when asked to move a package that begins moving, complications arise.', '2002', 'English', 8.5, '120', 'Jason Statham', 'da', 'ne', '', NULL, '', '');

-- --------------------------------------------------------

--
-- Структура таблицы `klient`
--

CREATE TABLE `klient` (
  `id` int(11) NOT NULL,
  `id_klienta` varchar(20) NOT NULL,
  `imie` varchar(45) NOT NULL,
  `nazwisko` varchar(45) NOT NULL,
  `adres` varchar(45) NOT NULL,
  `telefon` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT '',
  `pesel` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `klient`
--

INSERT INTO `klient` (`id`, `id_klienta`, `imie`, `nazwisko`, `adres`, `telefon`, `email`, `pesel`) VALUES
(20, 'UVOWEC', 'whtsj', 'sjjfjgf', 'rjtyk', 'skhk', 'ajgasjg', '47354');

-- --------------------------------------------------------

--
-- Структура таблицы `security`
--

CREATE TABLE `security` (
  `id` int(11) NOT NULL,
  `kod` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `security`
--

INSERT INTO `security` (`id`, `kod`) VALUES
(1, 'demo');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `background`
--
ALTER TABLE `background`
  ADD UNIQUE KEY `pozadina_UNIQUE` (`background`);

--
-- Индексы таблицы `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `klient`
--
ALTER TABLE `klient`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `security`
--
ALTER TABLE `security`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `klient`
--
ALTER TABLE `klient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
