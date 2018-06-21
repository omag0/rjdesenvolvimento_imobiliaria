package com.rjdesenvolvimento.imobiliaria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImobiliariaApplication implements CommandLineRunner {

  /*  @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private BairroRepository bairroRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;*/


    public static void main(String[] args) {
        SpringApplication.run(ImobiliariaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*
        Cliente cliente1 = new PessoaFisica("Rodrigo", "012.668.833-80", "12345", "rodrigo_batistasantos@hotmail.com",
                "16/04/1985", "Goiania0", "Desenvolvedor", Genero.MASCULINO, EstadoCivil.CASADO, PessoaFisicaTipo.CLIENTE);

        Usuario usuario1 = new Usuario("12300", "asdasd", (PessoaFisica) cliente1);

        Cliente cliente2 = new PessoaJuridica("Carlos alberto", "JSF funcionarios", "12/12/1333", "123123123",
                "12312312", PessoaJuridicaTipo.CLIENTE);
        Pais pais1 = new Pais("Brasil");

        Estado estado1 = new Estado("Mato Grosso do Sul", Uf.MS, pais1);

        Cidade cidade1 = new Cidade("Dourados", estado1);

        Bairro bairro1 = new Bairro("jardim novo horizonte", "Asturio Martins", "1955C", "S/C", "79808-555",
                TipoDeEndereco.RESIDENCIAL, cidade1);

        Bairro bairro2 = new Bairro("Coisa de Deus", "Asturio Martins", "1955C", "S/C", "79808-555",
                TipoDeEndereco.COMERCIAL, cidade1);

        Telefone telefone1 = new Telefone("98-88855-8885", TipoDeTelefone.CELULAR);
        Telefone telefone2 = new Telefone("98-3303-3333", TipoDeTelefone.COMERCIAL);

        pais1.getEstados().addAll(Arrays.asList(estado1));

        estado1.getCidades().addAll(Arrays.asList(cidade1));

        cidade1.getBairros().addAll(Arrays.asList(bairro1, bairro2));

        ((PessoaFisica) cliente1).getBairros().addAll(Arrays.asList(bairro1));
        ((PessoaJuridica) cliente2).getBairros().addAll(Arrays.asList(bairro2));

        bairro1.getPessoasFisicas().addAll(Arrays.asList((PessoaFisica) cliente1));
        bairro2.getPessoasJuridicas().addAll(Arrays.asList((PessoaJuridica) cliente2));

        telefone1.getPessoasFisicas().addAll(Arrays.asList((PessoaFisica) cliente1));
        telefone2.getPessoasJuridicas().addAll(Arrays.asList((PessoaJuridica) cliente2));

        ((PessoaFisica) cliente1).getTelefones().addAll(Arrays.asList(telefone1));
        ((PessoaJuridica) cliente2).getTelefones().addAll(Arrays.asList(telefone2));

        ((PessoaFisica) cliente1).getPessoasJuridicas().addAll(Arrays.asList((PessoaJuridica) cliente2));
        ((PessoaJuridica) cliente2).getSociosProprietarios().addAll(Arrays.asList((PessoaFisica) cliente1));


        paisRepository.saveAll(Arrays.asList(pais1));
        estadoRepository.saveAll(Arrays.asList(estado1));
        cidadeRepository.saveAll(Arrays.asList(cidade1));
        bairroRepository.saveAll(Arrays.asList(bairro1, bairro2));
        telefoneRepository.saveAll(Arrays.asList(telefone1, telefone2));
        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
        usuarioRepository.saveAll(Arrays.asList(usuario1));*/


    }
}
