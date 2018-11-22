-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 22-Nov-2018 às 14:26
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `locaplus`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `cnh` varchar(20) NOT NULL,
  `ndependentes` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `data` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao`
--

DROP TABLE IF EXISTS `locacao`;
CREATE TABLE IF NOT EXISTS `locacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datalocacao` varchar(20) NOT NULL,
  `cliente` varchar(100) NOT NULL,
  `veiculo` varchar(50) NOT NULL,
  `dataencerramento` varchar(20) DEFAULT NULL,
  `km` float DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `melhoria`
--

DROP TABLE IF EXISTS `melhoria`;
CREATE TABLE IF NOT EXISTS `melhoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario` varchar(100) NOT NULL,
  `melhoria` varchar(100) NOT NULL,
  `departamento` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculos`
--

DROP TABLE IF EXISTS `veiculos`;
CREATE TABLE IF NOT EXISTS `veiculos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `valorseguro` varchar(10) NOT NULL,
  `valorlocacao` varchar(10) NOT NULL,
  `ativo` varchar(5) NOT NULL,
  `cor` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
