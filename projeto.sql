-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 10-Dez-2018 às 03:26
-- Versão do servidor: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projeto`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `data_nasc` varchar(10) NOT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `telefone` varchar(20) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nome`, `data_nasc`, `rg`, `cpf`, `email`, `telefone`, `bairro`, `rua`, `numero`) VALUES
(2, 'JC', '11/11/1111', '78.587.667-87', '876.786.786-87', 'JC@gmail.com', '(11)11111-1111', 'Bairro - teste', 'Rua - teste', 1),
(3, 'Maria', '11/11/1111', '32.423.423-42', '231.231.231-23', 'maria@gmail.com', '(33)33333-3333', 'teste - bairro', 'teste - rua', 22),
(4, 'cliente', '13/12/2018', '11.212.123-21', '675.676.567-56', 'cliente@gmail.com', '(33)33333-3333', 'teste', 'teste', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `idconsulta` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idprocedimento` int(11) NOT NULL,
  `preco_consulta` varchar(14) NOT NULL,
  `horario` varchar(11) NOT NULL,
  `nomecli` varchar(100) NOT NULL,
  `data_atual` varchar(20) NOT NULL,
  `data_consulta` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`idconsulta`, `idcliente`, `idprocedimento`, `preco_consulta`, `horario`, `nomecli`, `data_atual`, `data_consulta`) VALUES
(5, 3, 3, '$80.5', '22:22', 'Maria', '06/12/2018', '14/12/2018');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `nome`, `login`, `senha`) VALUES
(1, 'Administrador', 'qwe', '123'),
(2, 'Administrador - 2', 'jc', '123'),
(3, 'tu', 'tu', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `procedimento`
--

CREATE TABLE `procedimento` (
  `cod` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `procedimento`
--

INSERT INTO `procedimento` (`cod`, `nome`, `preco`) VALUES
(3, 'Mnutenção do aparelho', 80.5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Indexes for table `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`idconsulta`),
  ADD KEY `consulta_ibfk_1` (`idcliente`),
  ADD KEY `consulta_ibfk_2` (`idprocedimento`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Indexes for table `procedimento`
--
ALTER TABLE `procedimento`
  ADD PRIMARY KEY (`cod`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `consulta`
--
ALTER TABLE `consulta`
  MODIFY `idconsulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `procedimento`
--
ALTER TABLE `procedimento`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`idprocedimento`) REFERENCES `procedimento` (`cod`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
