-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2018 at 03:09 AM
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
CREATE DATABASE IF NOT EXISTS `dbgaram` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbgaram`;

-- --------------------------------------------------------

--
-- Table structure for table `tbabsen`
--

CREATE TABLE `tbabsen` (
  `IdAbsen` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `IdKaryawan` int(11) NOT NULL,
  `Hadir` tinyint(1) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbabsen`
--

INSERT INTO `tbabsen` (`IdAbsen`, `Tanggal`, `IdKaryawan`, `Hadir`, `Keterangan`) VALUES
(1, '2017-12-30', 1, 1, ''),
(2, '2017-12-30', 2, 1, ''),
(3, '2017-12-30', 3, 1, ''),
(4, '2017-12-30', 4, 1, ''),
(5, '2017-12-30', 5, 1, ''),
(6, '2017-12-30', 6, 1, ''),
(7, '2017-12-30', 7, 1, ''),
(8, '2017-12-30', 8, 1, ''),
(9, '2017-12-30', 9, 1, ''),
(10, '2017-12-30', 10, 1, ''),
(11, '2017-12-30', 11, 1, ''),
(12, '2017-12-30', 12, 1, ''),
(13, '2017-12-30', 13, 1, ''),
(14, '2017-12-30', 14, 1, ''),
(15, '2017-12-30', 15, 1, ''),
(16, '2017-12-30', 16, 1, ''),
(17, '2017-12-30', 17, 1, ''),
(18, '2017-12-30', 18, 1, ''),
(19, '2017-12-30', 19, 1, ''),
(20, '2017-12-30', 20, 1, ''),
(21, '2017-12-30', 21, 1, ''),
(22, '2017-12-30', 22, 1, ''),
(23, '2017-12-30', 23, 1, ''),
(24, '2017-12-30', 25, 1, ''),
(25, '2017-12-30', 26, 1, ''),
(26, '2017-12-30', 27, 1, ''),
(27, '2017-12-30', 28, 1, ''),
(28, '2017-12-30', 29, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tblogin`
--

CREATE TABLE `tblogin` (
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Level` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblogin`
--

INSERT INTO `tblogin` (`Username`, `Password`, `Level`) VALUES
('', 'd41d8cd98f00b204e9800998ecf8427e', 2),
('admin', '21232f297a57a5a743894a0e4a801fc3', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbmbarang`
--

CREATE TABLE `tbmbarang` (
  `IdBarang` int(11) NOT NULL,
  `AliasBarang` varchar(50) NOT NULL,
  `NamaBarang` varchar(80) NOT NULL,
  `IdJenisBarang` int(11) NOT NULL,
  `Satuan` decimal(11,2) NOT NULL,
  `Harga` int(11) NOT NULL,
  `UpahPacking` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmbarang`
--

INSERT INTO `tbmbarang` (`IdBarang`, `AliasBarang`, `NamaBarang`, `IdJenisBarang`, `Satuan`, `Harga`, `UpahPacking`, `Keterangan`, `Status`) VALUES
(1, 'G.K NON YOD BAHAN', 'G. KASAR NON YOD BAHAN', 1, '50.00', 0, 0, '', 1),
(2, 'G.H YOD BAHAN', 'G. HALUS YODIUM BAHAN', 1, '50.00', 0, 0, '', 1),
(3, 'G.K NON YOD 50 KG', 'G. KASAR NON YOD @50KG', 2, '50.00', 0, 0, '', 1),
(4, 'G.K NON YOD 5 KG', 'G. KASAR NON YOD @5KG', 2, '50.00', 0, 0, '\n', 1),
(5, 'G.H YOD 50 KG', 'GARAM HALUS YOD @50KG', 2, '50.00', 0, 0, '\n', 1),
(6, 'G.KOTOR 50KG', 'GARAM KOTOR @50KG', 2, '50.00', 0, 0, '\n', 1),
(7, 'G.K 1KG', 'GARAM KASAR @1KG', 2, '10.00', 50000, 450, '\n', 1),
(8, 'G.K 1/4 KG (20)', 'G. KASAR 1/4 KG @5KG', 2, '5.00', 30500, 490, '\n', 1),
(9, 'G.K 8 ONS', 'GARAM KASAR 8 ONS', 2, '8.00', 48000, 400, '\n', 1),
(10, 'G.K 1/2 KG', 'GARAM KASAR 1/2KG', 2, '10.00', 61000, 600, '\n', 1),
(11, 'G.K 1/4 KG (40)', 'G. KASAR 1/4KG @10KG', 2, '10.00', 60000, 950, '\n', 1),
(12, 'G.H 150 GR', 'GARAM HALUS 150 GRAM', 2, '7.50', 51500, 1175, '\n', 1),
(13, 'G.H 1/4 KG', 'GARAM HALUS 1/4KG', 2, '10.00', 63500, 1030, '\n', 1),
(14, 'G.H 1/2 KG', 'GARAM HALUS 1/2 KG', 2, '10.00', 63500, 700, '\n', 1),
(15, 'G.H 800 ONS', 'GARAM HALUS 8 ONS', 2, '0.80', 60000, 450, '\n', 1),
(16, 'G.H 1 KG', 'GARAM HALUS 1 KG', 2, '1.00', 62500, 530, '\n', 1),
(17, 'G.K PERSERO', 'GARAM KASAR PERSERO', 1, '50.00', 0, 0, '\n', 1),
(18, 'G.K MEDAN', 'GARAM KASAR MEDAN', 1, '50.00', 0, 0, '', 1),
(19, 'asd', 'adwas', 2, '10.00', 54, 450, '', 1),
(20, 'dasda', 'asdas', 2, '35.00', 30, 450, '', 1),
(21, 'dajsdbas', 'asdasj', 2, '213.00', 412, 312, '\n', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbmcustomer`
--

CREATE TABLE `tbmcustomer` (
  `IdCustomer` int(11) NOT NULL,
  `Customer` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmcustomer`
--

INSERT INTO `tbmcustomer` (`IdCustomer`, `Customer`, `Keterangan`) VALUES
(1, 'PT. GARINDO', ''),
(2, 'PT. PERSERO', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmgudang`
--

CREATE TABLE `tbmgudang` (
  `IdGudang` int(11) NOT NULL,
  `Gudang` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmgudang`
--

INSERT INTO `tbmgudang` (`IdGudang`, `Gudang`, `Keterangan`) VALUES
(1, 'PAAL 5', ''),
(2, 'TALANGDUKU', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmkaryawan`
--

CREATE TABLE `tbmkaryawan` (
  `IdKaryawan` int(11) NOT NULL,
  `NamaKaryawan` varchar(50) NOT NULL,
  `IdJenisKaryawan` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmkaryawan`
--

INSERT INTO `tbmkaryawan` (`IdKaryawan`, `NamaKaryawan`, `IdJenisKaryawan`, `Keterangan`, `Status`) VALUES
(1, 'MUSLIM', 1, '', 1),
(2, 'SAHRUL', 1, '\n', 1),
(3, 'DEDI. S', 1, '\n', 1),
(4, 'OKTI. F', 1, '\n', 1),
(5, 'HERMAN', 1, '\n', 1),
(6, 'HASAN', 1, '\n', 1),
(7, 'MAHMUD', 1, '', 1),
(8, 'AMBAR', 2, '', 1),
(9, 'MUSLINA', 2, '', 1),
(10, 'SINAP', 2, '', 1),
(11, 'KAYATI', 2, '', 1),
(12, 'NILA', 2, '', 1),
(13, 'MISTIA', 2, '\n', 1),
(14, 'SUSILAWATI', 2, '\n', 1),
(15, 'MARTINA', 2, '\n', 1),
(16, 'TANIA', 2, '\n', 1),
(17, 'EKA', 2, '\n', 1),
(18, 'NETI', 2, '\n', 1),
(19, 'PUTRI', 2, '\n', 1),
(20, 'FITRI', 2, '\n', 1),
(21, 'NISWARI', 2, '\n', 1),
(22, 'BAITI', 2, '\n', 1),
(23, 'DESMIATI', 2, '\n', 1),
(25, 'SIMOR', 2, '\n', 1),
(26, 'RANI', 2, '\n', 1),
(27, 'ENI KUSUMA', 2, '\n', 1),
(28, 'AZIMA', 2, '\n', 1),
(29, 'SANTI', 2, '\n', 1),
(30, 'asdas', 2, '', 1),
(31, 'sdqw', 1, '', 1),
(32, 'martono', 2, 'dari1', 1),
(33, '3636', 1, '3', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbmkendaraan`
--

CREATE TABLE `tbmkendaraan` (
  `IdKendaraan` int(11) NOT NULL,
  `Plat` varchar(12) NOT NULL,
  `JenisKendaraan` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmkendaraan`
--

INSERT INTO `tbmkendaraan` (`IdKendaraan`, `Plat`, `JenisKendaraan`, `Keterangan`) VALUES
(1, 'BM 8119 CI', 'L300', ''),
(2, 'BH 8846 MB', 'BOX', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmpeminta`
--

CREATE TABLE `tbmpeminta` (
  `IdPeminta` int(11) NOT NULL,
  `Peminta` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmpeminta`
--

INSERT INTO `tbmpeminta` (`IdPeminta`, `Peminta`, `Keterangan`) VALUES
(1, 'PT. INTI GARAM CEMERLANG', ''),
(2, 'Jarkasih', ''),
(3, 'William', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmpenerima`
--

CREATE TABLE `tbmpenerima` (
  `IdPenerima` int(11) NOT NULL,
  `Penerima` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmpenerima`
--

INSERT INTO `tbmpenerima` (`IdPenerima`, `Penerima`, `Keterangan`) VALUES
(1, 'JASRIL', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmutasi`
--

CREATE TABLE `tbmutasi` (
  `IdMutasi` int(11) NOT NULL,
  `Tanggal` int(11) NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `Jumlah` decimal(11,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbpacking`
--

CREATE TABLE `tbpacking` (
  `IdPacking` int(11) NOT NULL,
  `NoPacking` varchar(20) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `NoBak` int(11) NOT NULL,
  `NoPas` int(11) NOT NULL,
  `NoIndi` int(11) NOT NULL,
  `IdKaryawan` int(11) NOT NULL,
  `IdBarangBahan` int(11) NOT NULL,
  `JumlahBahan` decimal(11,2) NOT NULL,
  `IdBarangHasil` int(11) NOT NULL,
  `JumlahHasil` decimal(11,2) NOT NULL,
  `UpahPerPak` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpacking`
--

INSERT INTO `tbpacking` (`IdPacking`, `NoPacking`, `Tanggal`, `NoBak`, `NoPas`, `NoIndi`, `IdKaryawan`, `IdBarangBahan`, `JumlahBahan`, `IdBarangHasil`, `JumlahHasil`, `UpahPerPak`, `Keterangan`) VALUES
(23, 'GG-000001-PG', '2018-01-05 00:00:00', 1, 1, 1, 8, 2, '4.50', 12, '37.50', 1175, ''),
(24, 'GG-000001-PG', '2018-01-05 00:00:00', 1, 1, 2, 9, 2, '4.50', 12, '37.50', 1175, ''),
(25, 'GG-000001-PG', '2018-01-05 00:00:00', 1, 2, 3, 10, 2, '4.50', 12, '20.50', 1175, ''),
(26, 'GG-000001-PG', '2018-01-05 00:00:00', 1, 2, 4, 11, 2, '4.50', 12, '20.50', 1175, ''),
(27, 'GG-000002-PG', '2018-01-05 00:00:00', 2, 3, 1, 13, 2, '4.25', 12, '31.00', 1175, ''),
(28, 'GG-000002-PG', '2018-01-05 00:00:00', 2, 3, 2, 12, 2, '4.25', 12, '31.00', 1175, ''),
(29, 'GG-000002-PG', '2018-01-05 00:00:00', 2, 4, 3, 15, 2, '4.25', 12, '23.00', 1175, ''),
(30, 'GG-000002-PG', '2018-01-05 00:00:00', 2, 4, 4, 14, 2, '4.25', 12, '23.00', 1175, ''),
(31, 'GG-000003-PG', '2018-01-05 00:00:00', 3, 5, 1, 16, 2, '5.33', 12, '31.00', 1175, ''),
(32, 'GG-000003-PG', '2018-01-05 00:00:00', 3, 6, 3, 18, 2, '5.33', 12, '34.00', 1175, ''),
(33, 'GG-000003-PG', '2018-01-05 00:00:00', 3, 6, 4, 20, 2, '5.33', 12, '34.00', 1175, ''),
(34, 'GG-000004-PG', '2018-01-05 00:00:00', 4, 7, 1, 21, 2, '6.00', 12, '6.00', 1175, ''),
(35, 'GG-000005-PG', '2018-01-05 00:00:00', 5, 9, 1, 22, 2, '5.00', 12, '30.00', 1175, ''),
(36, 'GG-000005-PG', '2018-01-05 00:00:00', 5, 9, 2, 23, 2, '5.00', 12, '30.00', 1175, ''),
(37, 'GG-000005-PG', '2018-01-05 00:00:00', 5, 10, 3, 25, 2, '5.00', 12, '37.50', 1175, ''),
(38, 'GG-000005-PG', '2018-01-05 00:00:00', 5, 10, 4, 26, 2, '5.00', 12, '37.50', 1175, ''),
(43, 'GG-000006-PG', '2018-01-05 00:00:00', 1, 1, 1, 8, 1, '6.50', 10, '35.50', 600, ''),
(44, 'GG-000006-PG', '2018-01-05 00:00:00', 1, 1, 2, 9, 1, '6.50', 10, '35.50', 600, ''),
(45, 'GG-000006-PG', '2018-01-05 00:00:00', 1, 2, 3, 10, 1, '6.50', 10, '36.00', 600, ''),
(46, 'GG-000006-PG', '2018-01-05 00:00:00', 1, 2, 4, 11, 1, '6.50', 10, '36.00', 600, ''),
(47, 'GG-000007-PG', '2018-01-05 00:00:00', 2, 3, 1, 13, 1, '6.50', 10, '36.00', 600, ''),
(48, 'GG-000007-PG', '2018-01-05 00:00:00', 2, 3, 2, 12, 1, '6.50', 10, '36.00', 600, ''),
(49, 'GG-000007-PG', '2018-01-05 00:00:00', 2, 4, 3, 14, 1, '6.50', 10, '34.00', 600, ''),
(50, 'GG-000007-PG', '2018-01-05 00:00:00', 2, 4, 4, 15, 1, '6.50', 10, '34.00', 600, ''),
(55, 'GG-000009-PG', '2018-01-05 00:00:00', 4, 7, 1, 20, 1, '8.67', 10, '31.50', 600, ''),
(56, 'GG-000009-PG', '2018-01-05 00:00:00', 4, 7, 2, 28, 1, '8.67', 10, '31.50', 600, ''),
(57, 'GG-000009-PG', '2018-01-05 00:00:00', 4, 8, 3, 21, 1, '8.67', 10, '70.00', 600, ''),
(58, 'GG-000010-PG', '2018-01-05 00:00:00', 5, 9, 1, 25, 1, '13.00', 10, '36.50', 600, ''),
(59, 'GG-000010-PG', '2018-01-05 00:00:00', 5, 9, 2, 26, 1, '13.00', 10, '36.50', 600, ''),
(60, 'GG-000011-PG', '2018-01-05 00:00:00', 1, 1, 1, 8, 1, '6.50', 9, '52.00', 400, ''),
(61, 'GG-000011-PG', '2018-01-05 00:00:00', 1, 1, 2, 9, 1, '6.50', 9, '52.00', 400, ''),
(62, 'GG-000011-PG', '2018-01-05 00:00:00', 1, 2, 3, 11, 1, '6.50', 9, '15.50', 400, ''),
(63, 'GG-000011-PG', '2018-01-05 00:00:00', 1, 2, 4, 10, 1, '6.50', 9, '15.50', 400, ''),
(64, 'GG-000012-PG', '2018-01-05 00:00:00', 2, 3, 1, 13, 1, '9.00', 9, '53.50', 400, ''),
(65, 'GG-000012-PG', '2018-01-05 00:00:00', 2, 3, 2, 12, 1, '9.00', 9, '53.50', 400, ''),
(66, 'GG-000012-PG', '2018-01-05 00:00:00', 2, 4, 3, 14, 1, '9.00', 9, '46.00', 400, ''),
(67, 'GG-000012-PG', '2018-01-05 00:00:00', 2, 4, 4, 15, 1, '9.00', 9, '46.00', 400, ''),
(68, 'GG-000013-PG', '2018-01-05 00:00:00', 3, 5, 1, 16, 1, '7.75', 9, '38.00', 400, ''),
(69, 'GG-000013-PG', '2018-01-05 00:00:00', 3, 5, 2, 29, 1, '7.75', 9, '38.00', 400, ''),
(70, 'GG-000013-PG', '2018-01-05 00:00:00', 3, 6, 3, 18, 1, '7.75', 9, '40.50', 400, ''),
(71, 'GG-000013-PG', '2018-01-05 00:00:00', 3, 6, 4, 19, 1, '7.75', 9, '40.50', 400, ''),
(72, 'GG-000014-PG', '2018-01-05 00:00:00', 4, 7, 1, 20, 1, '7.00', 9, '60.50', 400, ''),
(73, 'GG-000014-PG', '2018-01-05 00:00:00', 4, 7, 2, 28, 1, '7.00', 9, '60.50', 400, ''),
(74, 'GG-000014-PG', '2018-01-05 00:00:00', 4, 8, 3, 21, 1, '7.00', 9, '70.00', 400, ''),
(75, 'GG-000015-PG', '2018-01-05 00:00:00', 5, 9, 1, 21, 1, '5.00', 9, '67.50', 400, ''),
(76, 'GG-000015-PG', '2018-01-05 00:00:00', 5, 9, 2, 26, 1, '5.00', 9, '67.50', 400, ''),
(77, 'GG-000008-PG', '2018-01-05 00:00:00', 3, 5, 1, 16, 1, '6.50', 10, '37.00', 600, ''),
(78, 'GG-000008-PG', '2018-01-05 00:00:00', 3, 5, 2, 29, 1, '6.50', 10, '37.00', 600, ''),
(79, 'GG-000008-PG', '2018-01-05 00:00:00', 3, 6, 3, 18, 1, '6.50', 10, '40.00', 600, ''),
(80, 'GG-000008-PG', '2018-01-05 00:00:00', 3, 6, 4, 19, 1, '6.50', 10, '40.00', 600, ''),
(81, 'GG-000016-PG', '2018-01-05 00:00:00', 1, 1, 1, 8, 1, '6.50', 8, '42.50', 490, ''),
(82, 'GG-000016-PG', '2018-01-05 00:00:00', 1, 1, 2, 9, 1, '6.50', 8, '42.50', 490, ''),
(83, 'GG-000016-PG', '2018-01-05 00:00:00', 1, 2, 3, 10, 1, '6.50', 8, '27.50', 490, ''),
(84, 'GG-000016-PG', '2018-01-05 00:00:00', 1, 2, 4, 11, 1, '6.50', 8, '27.50', 490, ''),
(85, 'GG-000017-PG', '2018-01-05 00:00:00', 2, 3, 1, 13, 1, '6.50', 8, '38.50', 490, ''),
(86, 'GG-000017-PG', '2018-01-05 00:00:00', 2, 3, 2, 12, 1, '6.50', 8, '38.50', 490, ''),
(87, 'GG-000017-PG', '2018-01-05 00:00:00', 2, 4, 3, 14, 1, '6.50', 8, '31.00', 490, ''),
(88, 'GG-000017-PG', '2018-01-05 00:00:00', 2, 4, 4, 15, 1, '6.50', 8, '31.00', 490, ''),
(89, 'GG-000018-PG', '2018-01-05 00:00:00', 3, 5, 1, 16, 1, '8.67', 8, '47.00', 490, ''),
(90, 'GG-000018-PG', '2018-01-05 00:00:00', 3, 6, 3, 18, 1, '8.67', 8, '50.50', 490, ''),
(91, 'GG-000018-PG', '2018-01-05 00:00:00', 3, 6, 4, 19, 1, '8.67', 8, '50.50', 490, ''),
(92, 'GG-000019-PG', '2018-01-05 00:00:00', 4, 7, 1, 20, 1, '6.50', 8, '40.00', 490, ''),
(93, 'GG-000019-PG', '2018-01-05 00:00:00', 4, 7, 2, 28, 1, '6.50', 8, '40.00', 490, ''),
(94, 'GG-000019-PG', '2018-01-05 00:00:00', 4, 8, 3, 21, 1, '6.50', 8, '42.50', 490, ''),
(95, 'GG-000019-PG', '2018-01-05 00:00:00', 4, 8, 4, 27, 1, '6.50', 8, '42.50', 490, ''),
(96, 'GG-000020-PG', '2018-01-05 00:00:00', 5, 9, 1, 25, 1, '8.67', 8, '45.00', 490, ''),
(97, 'GG-000020-PG', '2018-01-05 00:00:00', 5, 9, 2, 26, 1, '8.67', 8, '45.00', 490, ''),
(98, 'GG-000020-PG', '2018-01-05 00:00:00', 5, 10, 3, 22, 1, '8.67', 8, '38.00', 490, ''),
(99, 'GG-000021-PG', '2018-01-05 00:00:00', 1, 1, 1, 8, 1, '6.50', 7, '53.00', 450, ''),
(100, 'GG-000021-PG', '2018-01-05 00:00:00', 1, 1, 2, 9, 1, '6.50', 7, '53.00', 450, ''),
(101, 'GG-000021-PG', '2018-01-05 00:00:00', 1, 2, 3, 11, 1, '6.50', 7, '38.00', 450, ''),
(102, 'GG-000021-PG', '2018-01-05 00:00:00', 1, 2, 4, 10, 1, '6.50', 7, '38.00', 450, ''),
(103, 'GG-000022-PG', '2018-01-05 00:00:00', 2, 3, 1, 13, 1, '9.00', 7, '60.00', 450, ''),
(104, 'GG-000022-PG', '2018-01-05 00:00:00', 2, 3, 2, 12, 1, '9.00', 7, '60.00', 450, ''),
(105, 'GG-000022-PG', '2018-01-05 00:00:00', 2, 4, 3, 14, 1, '9.00', 7, '58.00', 450, ''),
(106, 'GG-000022-PG', '2018-01-05 00:00:00', 2, 4, 4, 15, 1, '9.00', 7, '58.00', 450, ''),
(107, 'GG-000023-PG', '2018-01-05 00:00:00', 3, 5, 1, 16, 1, '7.00', 7, '37.00', 450, ''),
(108, 'GG-000023-PG', '2018-01-05 00:00:00', 3, 6, 3, 18, 1, '7.00', 7, '55.00', 450, ''),
(109, 'GG-000023-PG', '2018-01-05 00:00:00', 3, 6, 4, 19, 1, '7.00', 7, '55.00', 450, ''),
(110, 'GG-000024-PG', '2018-01-05 00:00:00', 4, 7, 1, 20, 1, '9.00', 7, '53.50', 450, ''),
(111, 'GG-000024-PG', '2018-01-05 00:00:00', 4, 7, 2, 28, 1, '9.00', 7, '53.50', 450, ''),
(112, 'GG-000024-PG', '2018-01-05 00:00:00', 4, 8, 3, 21, 1, '9.00', 7, '59.50', 450, ''),
(113, 'GG-000024-PG', '2018-01-05 00:00:00', 4, 8, 4, 27, 1, '9.00', 7, '59.50', 450, ''),
(114, 'GG-000025-PG', '2018-01-05 00:00:00', 5, 9, 1, 25, 1, '12.00', 7, '39.50', 450, ''),
(115, 'GG-000025-PG', '2018-01-05 00:00:00', 5, 9, 2, 26, 1, '12.00', 7, '39.50', 450, ''),
(116, 'GG-000025-PG', '2018-01-05 00:00:00', 5, 10, 3, 22, 1, '12.00', 7, '25.00', 450, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenerimaan`
--

CREATE TABLE `tbpenerimaan` (
  `IdPenerimaan` int(11) NOT NULL,
  `NoPenerimaan` varchar(12) NOT NULL,
  `NoTimbang` varchar(15) NOT NULL,
  `IdPeminta` int(11) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `BruttoPelita` int(11) NOT NULL,
  `TaraPelita` int(11) NOT NULL,
  `NettoPelita` int(11) NOT NULL,
  `NettoPenjual` int(11) NOT NULL,
  `Karung` int(11) NOT NULL,
  `Plat` varchar(11) NOT NULL,
  `IdCustomer` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenerimaan`
--

INSERT INTO `tbpenerimaan` (`IdPenerimaan`, `NoPenerimaan`, `NoTimbang`, `IdPeminta`, `Tanggal`, `IdBarang`, `BruttoPelita`, `TaraPelita`, `NettoPelita`, `NettoPenjual`, `Karung`, `Plat`, `IdCustomer`, `Keterangan`) VALUES
(1, 'GG-000001-PG', 'Y', 1, '2017-10-01 00:00:00', 1, 1, 1, 132750, 1, 2701, 'X', 1, '\n'),
(3, 'GG-000002-PG', 'Y', 1, '2017-10-02 00:00:00', 1, 1, 1, 39070, 1, 270, 'X', 1, ''),
(4, 'GG-000003-PG', 'Y', 1, '2017-10-03 00:00:00', 2, 1, 1, 40100, 1, 800, 'X', 1, ''),
(5, 'GG-000003-PG', 'Y', 1, '2017-10-03 00:00:00', 1, 1, 1, 27750, 1, 570, 'X', 1, '\n'),
(6, 'GG-000004-PG', 'Y', 1, '2017-10-04 00:00:00', 2, 1, 1, 17020, 1, 340, 'X', 1, '\n\n'),
(7, 'GG-000005-PG', 'Y', 1, '2017-10-07 00:00:00', 2, 1, 1, 21660, 1, 430, 'X', 1, '\n\n\n'),
(8, 'GG-000006-PG', 'Y', 1, '2017-10-26 00:00:00', 1, 1, 1, 28090, 1, 588, 'X', 1, '\n\n\n\n'),
(9, 'GG-000006-PG', 'Y', 1, '2017-10-28 00:00:00', 1, 1, 1, 22550, 1, 471, 'X', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenjualan`
--

CREATE TABLE `tbpenjualan` (
  `IdPenjualan` int(11) NOT NULL,
  `NoTransaksi` varchar(20) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `IdJenisPenjualan` int(11) NOT NULL,
  `IdKendaraan` int(11) NOT NULL,
  `IdGudang` int(11) DEFAULT NULL,
  `IdPenerima` int(11) DEFAULT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenjualan`
--

INSERT INTO `tbpenjualan` (`IdPenjualan`, `NoTransaksi`, `Tanggal`, `IdJenisPenjualan`, `IdKendaraan`, `IdGudang`, `IdPenerima`, `Keterangan`) VALUES
(4, 'GG-000001-SJ', '2018-01-05 00:00:00', 1, 2, 1, NULL, 'BARANG TERSEBUT DIATAS TELAH DIMUAT DENGAN BAIK DAN CUKUP DIMUAT OLEH BAGIAN GUDANG\n'),
(5, 'GG-000001-PJ', '2018-01-05 00:00:00', 2, 1, NULL, 1, ''),
(6, 'GG-000002-SJ', '2018-01-05 00:00:00', 1, 2, 1, NULL, ''),
(7, 'GG-000002-PJ', '2018-01-05 00:00:00', 2, 1, NULL, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenjualandetail`
--

CREATE TABLE `tbpenjualandetail` (
  `IdPenjualanDetail` int(11) NOT NULL,
  `NoTransaksi` varchar(20) NOT NULL,
  `NoKolom` int(11) NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `HargaSatuan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenjualandetail`
--

INSERT INTO `tbpenjualandetail` (`IdPenjualanDetail`, `NoTransaksi`, `NoKolom`, `IdBarang`, `Jumlah`, `HargaSatuan`) VALUES
(16, 'GG-000001-SJ', 1, 7, 450, 50000),
(18, 'GG-000001-PJ', 1, 7, 270, 50000),
(19, 'GG-000002-SJ', 1, 9, 250, 0),
(20, 'GG-000002-PJ', 1, 9, 200, 48000);

-- --------------------------------------------------------

--
-- Table structure for table `tbpenyesuaian`
--

CREATE TABLE `tbpenyesuaian` (
  `IdPenyesuaian` int(11) NOT NULL,
  `NoPenyesuaian` varchar(20) NOT NULL,
  `Tanggal` date NOT NULL,
  `IdBarang` int(11) NOT NULL,
  `Sak` decimal(11,2) NOT NULL,
  `Jumlah` decimal(11,2) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenyesuaian`
--

INSERT INTO `tbpenyesuaian` (`IdPenyesuaian`, `NoPenyesuaian`, `Tanggal`, `IdBarang`, `Sak`, `Jumlah`, `Keterangan`) VALUES
(1, 'GG-000001-PY', '2018-01-06', 1, '-0.50', '-0.50', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpoles`
--

CREATE TABLE `tbpoles` (
  `IdPoles` int(11) NOT NULL,
  `NoPoles` varchar(20) NOT NULL,
  `Tanggal` datetime NOT NULL,
  `Susut` int(11) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbpolesdetail`
--

CREATE TABLE `tbpolesdetail` (
  `IdPolesDetail` int(11) NOT NULL,
  `NoPoles` varchar(20) NOT NULL,
  `NoBahan` int(11) NOT NULL,
  `IdBarangBahan` int(11) NOT NULL,
  `JumlahBahan` int(11) NOT NULL,
  `SatuanBahan` varchar(15) NOT NULL,
  `KeteranganBahan` varchar(255) NOT NULL,
  `NoHasil` int(11) NOT NULL,
  `IdbarangHasil` int(11) NOT NULL,
  `JumlahHasil` int(11) NOT NULL,
  `SatuanHasil` varchar(15) NOT NULL,
  `KeteranganHasil` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbsmjenisbarang`
--

CREATE TABLE `tbsmjenisbarang` (
  `IdJenisBarang` int(11) NOT NULL,
  `JenisBarang` varchar(50) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbsmjenisbarang`
--

INSERT INTO `tbsmjenisbarang` (`IdJenisBarang`, `JenisBarang`, `Keterangan`) VALUES
(1, 'BAHAN', ''),
(2, 'HASIL', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbsmjeniskaryawan`
--

CREATE TABLE `tbsmjeniskaryawan` (
  `IdJenisKaryawan` int(11) NOT NULL,
  `JenisKaryawan` varchar(20) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbsmjeniskaryawan`
--

INSERT INTO `tbsmjeniskaryawan` (`IdJenisKaryawan`, `JenisKaryawan`, `Keterangan`) VALUES
(1, 'HARIAN', ''),
(2, 'BORONGAN', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbsmjenispenjualan`
--

CREATE TABLE `tbsmjenispenjualan` (
  `IdjenisPenjualan` int(11) NOT NULL,
  `JenisPenjualan` varchar(20) NOT NULL,
  `Keterangan` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbsmjenispenjualan`
--

INSERT INTO `tbsmjenispenjualan` (`IdjenisPenjualan`, `JenisPenjualan`, `Keterangan`) VALUES
(1, 'MUTASI GUDANG', ''),
(2, 'PENJUALAN', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbabsen`
--
ALTER TABLE `tbabsen`
  ADD PRIMARY KEY (`IdAbsen`);

--
-- Indexes for table `tblogin`
--
ALTER TABLE `tblogin`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `tbmbarang`
--
ALTER TABLE `tbmbarang`
  ADD PRIMARY KEY (`IdBarang`);

--
-- Indexes for table `tbmcustomer`
--
ALTER TABLE `tbmcustomer`
  ADD PRIMARY KEY (`IdCustomer`);

--
-- Indexes for table `tbmgudang`
--
ALTER TABLE `tbmgudang`
  ADD PRIMARY KEY (`IdGudang`);

--
-- Indexes for table `tbmkaryawan`
--
ALTER TABLE `tbmkaryawan`
  ADD PRIMARY KEY (`IdKaryawan`);

--
-- Indexes for table `tbmkendaraan`
--
ALTER TABLE `tbmkendaraan`
  ADD PRIMARY KEY (`IdKendaraan`);

--
-- Indexes for table `tbmpeminta`
--
ALTER TABLE `tbmpeminta`
  ADD PRIMARY KEY (`IdPeminta`);

--
-- Indexes for table `tbmpenerima`
--
ALTER TABLE `tbmpenerima`
  ADD PRIMARY KEY (`IdPenerima`);

--
-- Indexes for table `tbmutasi`
--
ALTER TABLE `tbmutasi`
  ADD PRIMARY KEY (`IdMutasi`);

--
-- Indexes for table `tbpacking`
--
ALTER TABLE `tbpacking`
  ADD PRIMARY KEY (`IdPacking`);

--
-- Indexes for table `tbpenerimaan`
--
ALTER TABLE `tbpenerimaan`
  ADD PRIMARY KEY (`IdPenerimaan`);

--
-- Indexes for table `tbpenjualan`
--
ALTER TABLE `tbpenjualan`
  ADD PRIMARY KEY (`IdPenjualan`);

--
-- Indexes for table `tbpenjualandetail`
--
ALTER TABLE `tbpenjualandetail`
  ADD PRIMARY KEY (`IdPenjualanDetail`);

--
-- Indexes for table `tbpenyesuaian`
--
ALTER TABLE `tbpenyesuaian`
  ADD PRIMARY KEY (`IdPenyesuaian`),
  ADD KEY `Penyesuaian` (`Jumlah`),
  ADD KEY `IdBarang` (`IdBarang`);

--
-- Indexes for table `tbpoles`
--
ALTER TABLE `tbpoles`
  ADD PRIMARY KEY (`IdPoles`);

--
-- Indexes for table `tbpolesdetail`
--
ALTER TABLE `tbpolesdetail`
  ADD PRIMARY KEY (`IdPolesDetail`);

--
-- Indexes for table `tbsmjenisbarang`
--
ALTER TABLE `tbsmjenisbarang`
  ADD PRIMARY KEY (`IdJenisBarang`);

--
-- Indexes for table `tbsmjeniskaryawan`
--
ALTER TABLE `tbsmjeniskaryawan`
  ADD PRIMARY KEY (`IdJenisKaryawan`);

--
-- Indexes for table `tbsmjenispenjualan`
--
ALTER TABLE `tbsmjenispenjualan`
  ADD PRIMARY KEY (`IdjenisPenjualan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbabsen`
--
ALTER TABLE `tbabsen`
  MODIFY `IdAbsen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `tbmbarang`
--
ALTER TABLE `tbmbarang`
  MODIFY `IdBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `tbmcustomer`
--
ALTER TABLE `tbmcustomer`
  MODIFY `IdCustomer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbmgudang`
--
ALTER TABLE `tbmgudang`
  MODIFY `IdGudang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbmkaryawan`
--
ALTER TABLE `tbmkaryawan`
  MODIFY `IdKaryawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `tbmkendaraan`
--
ALTER TABLE `tbmkendaraan`
  MODIFY `IdKendaraan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbmpeminta`
--
ALTER TABLE `tbmpeminta`
  MODIFY `IdPeminta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbmpenerima`
--
ALTER TABLE `tbmpenerima`
  MODIFY `IdPenerima` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbmutasi`
--
ALTER TABLE `tbmutasi`
  MODIFY `IdMutasi` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbpacking`
--
ALTER TABLE `tbpacking`
  MODIFY `IdPacking` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;
--
-- AUTO_INCREMENT for table `tbpenerimaan`
--
ALTER TABLE `tbpenerimaan`
  MODIFY `IdPenerimaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tbpenjualan`
--
ALTER TABLE `tbpenjualan`
  MODIFY `IdPenjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tbpenjualandetail`
--
ALTER TABLE `tbpenjualandetail`
  MODIFY `IdPenjualanDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `tbpenyesuaian`
--
ALTER TABLE `tbpenyesuaian`
  MODIFY `IdPenyesuaian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbpoles`
--
ALTER TABLE `tbpoles`
  MODIFY `IdPoles` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbpolesdetail`
--
ALTER TABLE `tbpolesdetail`
  MODIFY `IdPolesDetail` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbsmjenisbarang`
--
ALTER TABLE `tbsmjenisbarang`
  MODIFY `IdJenisBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbsmjeniskaryawan`
--
ALTER TABLE `tbsmjeniskaryawan`
  MODIFY `IdJenisKaryawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbsmjenispenjualan`
--
ALTER TABLE `tbsmjenispenjualan`
  MODIFY `IdjenisPenjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
