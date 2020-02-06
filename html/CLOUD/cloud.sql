-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2020 at 11:46 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cloud`
--

-- --------------------------------------------------------

--
-- Table structure for table `category_info`
--

CREATE TABLE `category_info` (
  `category_id` int(11) NOT NULL,
  `category_name` text NOT NULL,
  `institution` text NOT NULL,
  `description` text NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category_info`
--

INSERT INTO `category_info` (`category_id`, `category_name`, `institution`, `description`, `user_id`) VALUES
(5, 'category 1', 'kgisl', 'category description', 4),
(6, 'marriage', '', 'marrage photos', 5),
(7, 'marriage', '', '', 6);

-- --------------------------------------------------------

--
-- Table structure for table `file_info`
--

CREATE TABLE `file_info` (
  `id` int(11) NOT NULL,
  `note_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `file_link` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `file_info`
--

INSERT INTO `file_info` (`id`, `note_id`, `name`, `file_link`, `user_id`, `time`) VALUES
(7, 3, '1b6d9a80-3dbb-4fb7-9986-a7aeaeab839f-a306639f-fe0e-4a1f-b314-21e84b4ac9b8_compressed_40.jpg', 'data/jpg/1b6d9a80-3dbb-4fb7-9986-a7aeaeab839f-a306639f-fe0e-4a1f-b314-21e84b4ac9b8_compressed_40.jpg', 5, '2020-01-27 10:02:55'),
(8, 4, 'what.jpeg', 'data/jpg/what.jpeg', 6, '2020-01-27 10:43:44');

-- --------------------------------------------------------

--
-- Table structure for table `note_info`
--

CREATE TABLE `note_info` (
  `note_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `description` text NOT NULL,
  `topic` text NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `note_info`
--

INSERT INTO `note_info` (`note_id`, `title`, `description`, `topic`, `user_id`) VALUES
(2, 'notes', 'nioe', '5', 4),
(3, 'marriage', '', '6', 5),
(4, 'reception', '', '7', 6);

-- --------------------------------------------------------

--
-- Table structure for table `topic_info`
--

CREATE TABLE `topic_info` (
  `topic_id` int(11) NOT NULL,
  `topic_name` text NOT NULL,
  `institution` text NOT NULL,
  `description` text NOT NULL,
  `category` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `topic_info`
--

INSERT INTO `topic_info` (`topic_id`, `topic_name`, `institution`, `description`, `category`, `user_id`) VALUES
(6, 'reception', '', '', 6, 5),
(7, 'mythili marriage', '', '', 7, 6);

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `uid` int(10) NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `phone` text NOT NULL,
  `institution` text NOT NULL,
  `place` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`uid`, `name`, `email`, `phone`, `institution`, `place`, `password`) VALUES
(6, 'Mythili', 'mythili@gmail.com', '0', 'LRG College', 'Tiruppur, India', 'dc84d013e975661d9a008d94d90cc8a7');

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
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `note_info`
--
ALTER TABLE `note_info`
  ADD PRIMARY KEY (`note_id`);

--
-- Indexes for table `topic_info`
--
ALTER TABLE `topic_info`
  ADD PRIMARY KEY (`topic_id`);

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
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `file_info`
--
ALTER TABLE `file_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `note_info`
--
ALTER TABLE `note_info`
  MODIFY `note_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `topic_info`
--
ALTER TABLE `topic_info`
  MODIFY `topic_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `uid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
