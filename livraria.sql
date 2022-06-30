--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL auto_increment primary key,
  `nomeCliente` varchar(45) NOT NULL,
  `cpf` varchar(20) DEFAULT NULL unique,
  `cnpj` varchar(20) DEFAULT NULL unique,
  `endereco` varchar(60) NOT NULL,
  `telefone` varchar(20) NOT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Estrutura da tabela `editora`
--

CREATE TABLE `editora` (
  `idEditora` int(11) NOT NULL auto_increment primary key,
  `nmEditora` varchar(45) NOT NULL,
  `endereco` varchar(60) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `gerente` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Estrutura da tabela `livro`
--

CREATE TABLE `livro` (
  `idLivro` int(11) NOT NULL auto_increment primary key,
  `titulo` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `assunto` varchar(45) NOT NULL,
  `isbn` varchar(13) NOT NULL unique,
  `estoque` int(11) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `idEditora` int(11) NOT NULL,
  foreign key (idEditora) references editora(idEditora)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- Estrutura da tabela `compra`
--

CREATE TABLE `vendaLivro` (
  `idCliente` int(11) NOT NULL auto_increment primary key,
  `idLivro` int(11) NOT NULL,
  `qtd` int(11) NOT NULL,
  `subTotal` decimal(10,2) NOT NULL,
  `dataCompra` date NOT NULL,
foreign key (idCliente) references cliente(idCliente),
foreign key (idLivro) references livro(idLivro)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
