-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 18 Apr 2018 pada 04.59
-- Versi Server: 10.1.21-MariaDB
-- PHP Version: 7.1.1

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
-- Struktur dari tabel `tbuser`
--

CREATE TABLE `tbuser` (
  `IdUser` int(10) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Level` enum('Administrator','Operator') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data untuk tabel `tbuser`
--

INSERT INTO `tbuser` (`IdUser`, `Username`, `Password`, `Level`) VALUES
(-1, 'ADMINISTRATOR', '0192023a7bbd73250516f069df18b500', 'Administrator'),
(1, 'ADMIN', '23e28d2439cbc6717d1f1e965f989420', 'Administrator'),
(2, 'RIKI', 'dc131ed8751b5ac500a79b1d7207929c', 'Operator'),
(4, 'MARTONO', 'af7936442257f4a1b39e5f7f1c4e2c1c', 'Operator'),
(5, 'HENDRI', '93a66e7391926e0d2d43bd6068477d71', 'Operator'),
(6, 'ARMAN', '93a66e7391926e0d2d43bd6068477d71', 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`IdUser`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbuser`
--
ALTER TABLE `tbuser`
  MODIFY `IdUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
