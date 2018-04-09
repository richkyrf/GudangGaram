-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2018 at 07:20 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbgaram`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbpemakaianlain`
--

CREATE TABLE `tbpemakaianlain` (
  `IdPenerimaanLain` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `IdBarangLain` int(11) NOT NULL,
  `Jumlah` decimal(11,2) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpemakaianlain`
--

INSERT INTO `tbpemakaianlain` (`IdPenerimaanLain`, `Tanggal`, `IdBarangLain`, `Jumlah`, `Keterangan`) VALUES
(1, '2018-03-01', 2, '0.75', ''),
(2, '2018-03-01', 3, '12.00', ''),
(3, '2018-03-02', 3, '12.00', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbpemakaianlain`
--
ALTER TABLE `tbpemakaianlain`
  ADD PRIMARY KEY (`IdPenerimaanLain`),
  ADD KEY `Tanggal` (`Tanggal`),
  ADD KEY `IdBarangLain` (`IdBarangLain`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbpemakaianlain`
--
ALTER TABLE `tbpemakaianlain`
  MODIFY `IdPenerimaanLain` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
