-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2015 at 01:46 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `students`
--

-- --------------------------------------------------------

--
-- Table structure for table `abscent`
--

CREATE TABLE IF NOT EXISTS `abscent` (
`id` smallint(5) NOT NULL,
  `student_id` smallint(5) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `abscent`
--

INSERT INTO `abscent` (`id`, `student_id`, `date`) VALUES
(1, 1, '2015-04-03'),
(4, 1, '2015-04-07'),
(5, 1, '2015-04-01'),
(11, 11, '2015-04-02'),
(15, 15, '2015-04-05');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE IF NOT EXISTS `logs` (
`id` mediumint(8) NOT NULL,
  `text` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`id`, `text`) VALUES
(1, 'Abscent row deleted'),
(2, 'Abscent row deleted'),
(3, 'Abscent row deleted'),
(4, 'Student row deleted'),
(5, 'Edited student row'),
(6, 'Edited student row'),
(7, 'Edited student row'),
(8, 'Edited student row'),
(9, 'Edited student row'),
(10, 'Edited student row'),
(11, 'Student added'),
(12, 'Student added'),
(13, 'Student added'),
(14, 'Student added'),
(15, 'Student added'),
(16, 'Student row deleted'),
(17, 'Abscent row deleted'),
(18, 'Edited student row'),
(19, 'Student added'),
(20, 'Student added'),
(21, 'Student row deleted'),
(22, 'Edited student row'),
(23, 'Student added'),
(24, 'Random text'),
(25, 'Student added'),
(26, 'Student added'),
(27, 'Edited student row'),
(28, 'Edited student row'),
(29, 'Edited student row'),
(30, 'Abscent row added'),
(31, 'Abscent row added'),
(32, 'Abscent row added'),
(33, 'Abscent row added'),
(34, 'Abscent row added'),
(35, 'Student row deleted'),
(36, 'Student row deleted'),
(37, 'Abscent row deleted'),
(38, 'Abscent row added'),
(39, 'Abscent row deleted'),
(40, 'Edited student row'),
(41, 'Edited student row'),
(42, 'Edited student row'),
(43, 'Edited student row');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
`id` smallint(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  `group_number` varchar(10) NOT NULL,
  `department` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `group_number`, `department`) VALUES
(1, 'Vova Perebykivskiy', '343', 'PZKS'),
(11, 'Stiven King', '342', 'FPM'),
(15, 'Dmytro1', '123', 'Moasd'),
(16, 'D1', 'dfs', 'dsf'),
(17, 'D1', 'dfs', 'dsf'),
(18, 'Alo', '123', 'asdfdf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `abscent`
--
ALTER TABLE `abscent`
 ADD PRIMARY KEY (`id`), ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `abscent`
--
ALTER TABLE `abscent`
MODIFY `id` smallint(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
MODIFY `id` mediumint(8) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
MODIFY `id` smallint(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
