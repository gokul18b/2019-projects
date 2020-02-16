-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2020 at 03:30 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `admission`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `admission`
--

CREATE TABLE `admission` (
  `id` int(11) NOT NULL,
  `application` text NOT NULL,
  `course` text NOT NULL,
  `amount` text NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `father` text NOT NULL,
  `mother` text NOT NULL,
  `age` text NOT NULL,
  `gender` text NOT NULL,
  `mobile` text NOT NULL,
  `email` text NOT NULL,
  `pincode` text NOT NULL,
  `sub1` text NOT NULL,
  `sub2` text NOT NULL,
  `sub3` text NOT NULL,
  `sub4` text NOT NULL,
  `sub5` text NOT NULL,
  `sub6` text NOT NULL,
  `address` text NOT NULL,
  `dob` text NOT NULL,
  `coursename` text NOT NULL,
  `cutoff` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `fathername` text NOT NULL,
  `mothername` text NOT NULL,
  `age` text NOT NULL,
  `gender` text NOT NULL,
  `mobile` text NOT NULL,
  `email` text NOT NULL,
  `pincode` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`firstname`, `lastname`, `fathername`, `mothername`, `age`, `gender`, `mobile`, `email`, `pincode`, `id`) VALUES
('j', 'kj', 'kj', 'kj', 'kj', 'Male', 'kj', 'jk', 'jk', 12570),
('gokul', 'balasubtamaniam', 'balu', 'banum', '22', 'Male', '7418227833', 'gokul`8b@gmail.com', '641602', 12571);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `coursename` text NOT NULL,
  `amount` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `coursename`, `amount`) VALUES
(1, 'coursename', 'amount'),
(2, 'ask', 'kj');

-- --------------------------------------------------------

--
-- Table structure for table `hostel`
--

CREATE TABLE `hostel` (
  `id` int(11) NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `father` text NOT NULL,
  `mother` text NOT NULL,
  `age` text NOT NULL,
  `gender` text NOT NULL,
  `mobile` text NOT NULL,
  `email` text NOT NULL,
  `pincode` text NOT NULL,
  `application` text NOT NULL,
  `roomno` text NOT NULL,
  `fees` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hostel`
--

INSERT INTO `hostel` (`id`, `firstname`, `lastname`, `father`, `mother`, `age`, `gender`, `mobile`, `email`, `pincode`, `application`, `roomno`, `fees`) VALUES
(1, 'fir', 'las', 'fath', 'mot', 'ag', 'gen', 'mob', 'email', 'pin', 'appl', 'room', 'fees'),
(2, 'gokul', 'balasubtamaniam', 'balu', 'banum', '22', 'Male', '7418227833', 'gokul`8b@gmail.com', '641602', '12571', 'lk', 'lk'),
(3, 'gokul', 'balasubtamaniam', 'balu', 'banum', '22', 'Male', '7418227833', 'gokul`8b@gmail.com', '641602', '12571', '45', '556');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admission`
--
ALTER TABLE `admission`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hostel`
--
ALTER TABLE `hostel`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `admission`
--
ALTER TABLE `admission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12572;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hostel`
--
ALTER TABLE `hostel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
