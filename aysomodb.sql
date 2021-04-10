-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2021 at 05:06 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aysomodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `reason` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `idEmployee` int(11) DEFAULT NULL,
  `idEmployer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`id`, `startDate`, `endDate`, `reason`, `state`, `idEmployee`, `idEmployer`) VALUES
(16, '2021-04-05', '2021-04-17', 'Going ALG', 'Refused', 1, 2),
(17, '2021-04-13', '2021-04-18', 'Going to Spain', 'Accepted', 3, 2),
(18, '2021-04-20', '2021-04-23', 'Sick', 'Accepted', 3, 2),
(21, '2021-04-05', '2021-04-08', 'funeral', 'Accepted', 1, 2),
(22, '2021-04-08', '2021-04-11', 'Vacation', 'Accepted', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `post` varchar(100) NOT NULL,
  `idEmployer` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `post`, `idEmployer`) VALUES
(1, 'Mohamed', 'Mohamed', 'ee', 2),
(2, 'Ayoub', 'Ayoub', 'er', NULL),
(3, 'Sonia', 'Sonia', 'ee', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
