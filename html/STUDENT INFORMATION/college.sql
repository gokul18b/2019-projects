-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 04, 2019 at 02:41 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `college`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  `I` varchar(1) NOT NULL,
  `II` varchar(1) NOT NULL,
  `III` varchar(1) NOT NULL,
  `IV` varchar(1) NOT NULL,
  `V` varchar(1) NOT NULL,
  `VI` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=768 ;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `sid`, `cid`, `date`, `I`, `II`, `III`, `IV`, `V`, `VI`) VALUES
(689, 39, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(688, 38, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(687, 37, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(686, 36, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(685, 35, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(684, 34, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(683, 33, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(682, 32, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(681, 31, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(680, 30, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(679, 29, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(678, 28, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(677, 27, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(676, 26, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(675, 25, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(674, 24, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(673, 23, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(672, 22, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(671, 21, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(670, 20, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(669, 19, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(668, 18, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(667, 17, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(666, 16, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(665, 15, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(664, 14, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(663, 13, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(662, 12, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(661, 11, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(660, 10, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(659, 9, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(658, 8, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(657, 7, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(656, 6, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(655, 5, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(654, 4, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(653, 2, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(652, 3, 2, '27-12-2017', 'A', '0', 'A', '0', '0', '0'),
(690, 40, 1, '27-12-2017', '0', 'A', 'A', '0', '0', '0'),
(691, 3, 2, '28-12-2017', 'A', 'A', 'A', '0', 'A', '0'),
(692, 2, 1, '28-12-2017', '0', 'P', 'P', 'P', '0', '0'),
(693, 4, 1, '28-12-2017', '0', 'A', 'P', 'P', '0', '0'),
(694, 5, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(695, 6, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(696, 7, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(697, 8, 1, '28-12-2017', '0', 'P', 'A', 'A', '0', '0'),
(698, 9, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(699, 10, 1, '28-12-2017', '0', 'P', 'A', 'A', '0', '0'),
(700, 11, 1, '28-12-2017', '0', 'P', 'A', 'A', '0', '0'),
(701, 12, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(702, 13, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(703, 14, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(704, 15, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(705, 16, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(706, 17, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(707, 18, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(708, 19, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(709, 20, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(710, 21, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(711, 22, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(712, 23, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(713, 24, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(714, 25, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(715, 26, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(716, 27, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(717, 28, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(718, 29, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(719, 30, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(720, 31, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(721, 32, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(722, 33, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(723, 34, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(724, 35, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(725, 36, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(726, 37, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(727, 38, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(728, 39, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(729, 40, 1, '28-12-2017', '0', 'A', 'A', 'A', '0', '0'),
(730, 2, 1, '08-01-2018', '0', 'P', 'A', '0', 'P', 'P'),
(731, 4, 1, '08-01-2018', '0', 'A', 'A', '0', 'P', 'A'),
(732, 5, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(733, 6, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(734, 7, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(735, 8, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(736, 9, 1, '08-01-2018', '0', 'A', 'A', '0', 'P', 'A'),
(737, 10, 1, '08-01-2018', '0', 'A', 'A', '0', 'P', 'A'),
(738, 11, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(739, 12, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(740, 13, 1, '08-01-2018', '0', 'A', 'A', '0', 'P', 'A'),
(741, 14, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(742, 15, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(743, 16, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(744, 17, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(745, 18, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(746, 19, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(747, 20, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(748, 21, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(749, 22, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(750, 23, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(751, 24, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(752, 25, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(753, 26, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(754, 27, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(755, 28, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(756, 29, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(757, 30, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(758, 31, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(759, 32, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(760, 33, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(761, 34, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(762, 35, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(763, 36, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(764, 37, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(765, 38, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(766, 39, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A'),
(767, 40, 1, '08-01-2018', '0', 'A', 'A', '0', 'A', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE IF NOT EXISTS `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`id`, `class_name`) VALUES
(1, 'I Bsc CS '),
(2, 'II Bsc CS '),
(3, 'III Bsc CS'),
(4, 'I Bsc IT'),
(5, 'II Bsc IT'),
(6, 'III Bsc IT'),
(7, 'I B.com '),
(8, 'II B.com'),
(9, 'III B.com');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat` text NOT NULL,
  `des` text NOT NULL,
  `date` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `cat`, `des`, `date`) VALUES
(10, 'test', 'test', '28-12-2017 (Thu) 00:03:15');

-- --------------------------------------------------------

--
-- Table structure for table `homework`
--

CREATE TABLE IF NOT EXISTS `homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `sub` text NOT NULL,
  `des` text NOT NULL,
  `given` int(11) NOT NULL,
  `date` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `homework`
--

INSERT INTO `homework` (`id`, `cid`, `sub`, `des`, `given`, `date`) VALUES
(9, 2, 'test', 'test', 1, '28-12-2017 (Thu) 00:02:45'),
(10, 1, 'java', 'oops concept write 2 times on monday', 1, '28-12-2017 (Thu) 00:26:14'),
(11, 1, 'test', 'test', 1, '08-01-2018 (Mon) 14:48:07'),
(12, 2, 'lyd', 'cnv', 1, '30-01-2018 (Tue) 11:49:13');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `u_type` varchar(1) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `age` int(2) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `image` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `cid`, `u_type`, `username`, `password`, `name`, `mobile`, `age`, `dob`, `email`, `image`) VALUES
(1, 1, 'T', 'g', 'g', 'Gokul', '2147483647', 23, '18-09-1994', 'gokul18b@mycollege.com', 'http://localhost/gokul/api/api/college/images/'),
(2, 1, 'S', 'madhan', 'madhan', 'Madhan', '2147483647', 12, '12-09-2001', 'madhan@gmail.com', 'http://localhost/gokul/api/api/college/images/'),
(3, 2, 'S', 'vani', 'vanima', 'Vanitha', '2147483647', 21, '10-09-1995', 'vani@gmail.com', 'http://localhost/gokul/api/api/college/images/'),
(4, 1, 'S', 'jagan', 'jagan', 'Jagan', '9898989898', 25, '12-12-1991', 'jagan@mycollege.com', 'http://localhost/gokul/api/api/college/images/'),
(5, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(6, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(7, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(8, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(9, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(10, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(11, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(12, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(13, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(14, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(15, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(16, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(17, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(18, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(19, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(20, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(21, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(22, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(23, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(24, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(25, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(26, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(27, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(28, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(29, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(30, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(31, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(32, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(33, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(34, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(35, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(36, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(37, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(38, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test'),
(39, 1, 'S', 'test', 'test', 'test', 'test', 2, 'test', 'test', 'test'),
(40, 1, 'S', 'test', 'test', 'test', 'test', 0, 'test', 'test', 'test');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
