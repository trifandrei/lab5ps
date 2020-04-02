-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2020 at 03:48 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bug_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `bug`
--

CREATE TABLE `bug` (
  `id` int(11) NOT NULL,
  `bug_name` varchar(50) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `screenshots` varchar(50) DEFAULT NULL,
  `tag` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bug`
--

INSERT INTO `bug` (`id`, `bug_name`, `product_id`, `screenshots`, `tag`) VALUES
(1, 'bug1', 1, 'c://img1.img', 'program1'),
(2, 'bug2', 2, 'c://img2.img', 'program2'),
(3, 'bug3', 1, 'c://img3.img', 'program1'),
(4, 'bug4', 3, 'c://img4.img', 'program3');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `nume` varchar(50) DEFAULT NULL,
  `e_mail` varchar(50) DEFAULT NULL,
  `asignned_bug` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`id`, `nume`, `e_mail`, `asignned_bug`) VALUES
(1, 'andrei', 'trifandrei@yahoo.com', 1),
(2, 'matei', 'mate1@yahoo.com', 2),
(3, 'paul', 'paul@yahoo.com', 3),
(4, 'andrei', 'trifandrei@yahoo.com', 1),
(5, 'matei', 'mate1@yahoo.com', 2),
(6, 'paul', 'paul@yahoo.com', 3),
(7, 'andrei', 'trifandrei@yahoo.com', 1),
(8, 'matei', 'mate1@yahoo.com', 2),
(9, 'paul', 'paul@yahoo.com', 3),
(10, 'andrei', 'trifandrei@yahoo.com', 1),
(11, 'matei', 'mate1@yahoo.com', 2),
(12, 'paul', 'paul@yahoo.com', 3);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `nume` varchar(50) DEFAULT NULL,
  `employ_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `nume`, `employ_id`) VALUES
(1, 'hard', 6),
(2, 'soft', 3);

-- --------------------------------------------------------

--
-- Table structure for table `progresion`
--

CREATE TABLE `progresion` (
  `id` int(11) NOT NULL,
  `id_bug` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `progresion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `progresion`
--

INSERT INTO `progresion` (`id`, `id_bug`, `status`, `progresion`) VALUES
(1, 1, 'hard', '50%');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bug`
--
ALTER TABLE `bug`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `asignned_bug` (`asignned_bug`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employ_id` (`employ_id`);

--
-- Indexes for table `progresion`
--
ALTER TABLE `progresion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_bug` (`id_bug`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bug`
--
ALTER TABLE `bug`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `progresion`
--
ALTER TABLE `progresion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `employe_ibfk_1` FOREIGN KEY (`asignned_bug`) REFERENCES `bug` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`employ_id`) REFERENCES `employe` (`id`);

--
-- Constraints for table `progresion`
--
ALTER TABLE `progresion`
  ADD CONSTRAINT `progresion_ibfk_1` FOREIGN KEY (`id_bug`) REFERENCES `bug` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
