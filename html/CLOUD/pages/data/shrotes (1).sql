-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 17, 2018 at 07:30 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.0.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shrotes`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_info`
--

CREATE TABLE `category_info` (
  `category_id` int(11) NOT NULL,
  `category_name` text NOT NULL,
  `institution` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category_info`
--

INSERT INTO `category_info` (`category_id`, `category_name`, `institution`, `description`) VALUES
(1, 'CG1', 'TRYDEVS', 'Testing CG1'),
(2, 'Java', '', ''),
(3, 'C++', '', ''),
(4, 'Python', '', ''),
(5, 'Web Development', '', ''),
(6, 'Android Development', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `file_info`
--

CREATE TABLE `file_info` (
  `file_id` int(11) NOT NULL,
  `note_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `file_link` text NOT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `file_info`
--

INSERT INTO `file_info` (`file_id`, `note_id`, `name`, `file_link`, `time`) VALUES
(1, 1, 'html-basic-tags.jpg', 'data/jpg/html-basic-tags.jpg', '2018-01-17 18:24:23');

-- --------------------------------------------------------

--
-- Table structure for table `note_info`
--

CREATE TABLE `note_info` (
  `note_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `description` text NOT NULL,
  `topic` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `note_info`
--

INSERT INTO `note_info` (`note_id`, `title`, `description`, `topic`) VALUES
(1, 'HTML', 'SOmething about html.', 0);

-- --------------------------------------------------------

--
-- Table structure for table `topic_info`
--

CREATE TABLE `topic_info` (
  `tid` int(11) NOT NULL,
  `topic_name` text NOT NULL,
  `institution` text NOT NULL,
  `description` text NOT NULL,
  `category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `topic_info`
--

INSERT INTO `topic_info` (`tid`, `topic_name`, `institution`, `description`, `category`) VALUES
(1, 'TP1', 'IJMHSS', 'Testing TP1', 1),
(2, 'Servlets', '', '', 2),
(3, 'Spring', '', '', 2),
(4, 'Hybernet', '', '', 2),
(5, 'HTML', '', '', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `phone` text NOT NULL,
  `institution` text NOT NULL,
  `place` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`uid`, `name`, `email`, `phone`, `institution`, `place`, `password`) VALUES
(2, 'localhost', 'localhost', '0', 'IJMHSS', 'Tiruppur', '04effd985329b12d8a821741b0ddda8f'),
(3, 'localhost1', 'localhost', '0', 'IJMHSS', 'Tiruppur', '04effd985329b12d8a821741b0ddda8f'),
(4, 'Sundareswaran C', 'localhost2', '0', 'IJMHSS', 'Tiruppur', '918957575d2a676c59ccb18a6f3f9d66'),
(5, 'Sundareswaran C', 'localhost2', '0', 'IJMHSS', 'Tiruppur', '918957575d2a676c59ccb18a6f3f9d66');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category_info`
--
ALTER TABLE `category_info`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `file_info`
--
ALTER TABLE `file_info`
  ADD PRIMARY KEY (`file_id`);

--
-- Indexes for table `note_info`
--
ALTER TABLE `note_info`
  ADD PRIMARY KEY (`note_id`);

--
-- Indexes for table `topic_info`
--
ALTER TABLE `topic_info`
  ADD PRIMARY KEY (`tid`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category_info`
--
ALTER TABLE `category_info`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `file_info`
--
ALTER TABLE `file_info`
  MODIFY `file_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `note_info`
--
ALTER TABLE `note_info`
  MODIFY `note_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `topic_info`
--
ALTER TABLE `topic_info`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
