import { TipoEndereco } from './../dominios/TipoEndereco';
import { RegimeCasamento } from './../dominios/RegimeCasamento';
import { EstadoCivil } from './../dominios/EstadoCivel';
import { PaisSC } from './../dominios/PaisSC';
import { PessoaDocumento } from './../interfaces/PessoaDocumento';
import { ExperienciaProfissional } from './../dominios/ExperienciaProfissional';
import { PessoaEmail } from './../dominios/PessoaEmail';
import { DetalhePessoaFisica } from './../dominios/DetalhePessoaFisica';
import { PessoaEndereco } from './../dominios/PessoaEndereco';
import { PessoaFisica } from './../dominios/PessoaFisica';
import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { Validators, FormControl, FormGroup, FormBuilder } from '@angular/forms';

import { SelectItem } from 'primeng/api';
import { MessageService } from 'primeng/api';

import { Pais } from './../interfaces/Pais';
import { PessoaSCP } from './../dominios/PessoaSCP';
import { Pessoa } from './../dominios/Pessoa';
import { PessoaService } from './../pessoa.service';
import { PessoaTelefone } from './../dominios/PessoaTelefone';



@Component({
  selector: 'app-form-pessoa',
  templateUrl: './form-pessoa.component.html',
  styleUrls: ['./form-pessoa.component.css']
})
export class FormPessoaComponent implements OnInit {

  //SelectItem API with label-value pairs

  emitPesquisaCPF = new EventEmitter();
  cpfPesquisado: string;
  pesquisaCPF: boolean = true;
  pessoa: Pessoa = <Pessoa>{};
  pessoaSalva: Pessoa = <Pessoa>{};
  pessoaFisica: PessoaFisica = <PessoaFisica>{};
  pessoaDocumentos: PessoaDocumento[] = <PessoaDocumento[]>[];
  pessoaEnderecos: PessoaEndereco[] = <PessoaEndereco[]>[];
  pessoaTelefones: PessoaTelefone[] = <PessoaTelefone[]>[];
  pessoaEmails: PessoaEmail[] = <PessoaEmail[]>[];
  experiencias: ExperienciaProfissional[] = <ExperienciaProfissional[]>[];
  detalhePessoaFisica: DetalhePessoaFisica = <DetalhePessoaFisica>{};
  detalhePessoaFisicaSalva: DetalhePessoaFisica = <DetalhePessoaFisica>{};
  dtNascimento: Date;

  nacionalidadePadrao: PaisSC = <PaisSC>{};
  nacionalidade: PaisSC = <PaisSC>{ "id": 31, "nmPais": "Brasil", "sgPais": "BRA" };
  estadoCivil: EstadoCivil = <EstadoCivil>{};
  regimeCasamento: RegimeCasamento = <RegimeCasamento>{};


  pessoaSCP: PessoaSCP = <PessoaSCP>{};
  //paises:any;

  paises: PaisSC[] = <PaisSC[]>[];

  listaDeEstadosCivis: any;
  ufs: any;
  listaDeRegimesDeCasamento: any;


  pessoaForm: FormGroup;
  telForm: FormGroup;
  submitted: boolean;
  naturalidade: Pais = <Pais>{};






  constructor(private fb: FormBuilder, private ps: PessoaService, private messageService: MessageService) {

  }

  ngOnInit() {


    this.paises[0] = this.nacionalidadePadrao = { "id": 31, "nmPais": "Brasil", "sgPais": "BRA" };
    this.ps.retornaListaDePaisesSC().subscribe(
      dadosDoServidor => {
        this.paises = dadosDoServidor;
      }
    );


    this.listaDeEstadosCivis = this.ps.retornaListaDeEstadosCivis();




    this.ufs = this.ps.retornaListaDeUFs();
    this.listaDeRegimesDeCasamento = this.ps.retornaListaDeRegimesDeCasamento();





    this.pessoaForm = this.fb.group({
      'nrCpf': new FormControl('', Validators.required),
      'nmPessoa': new FormControl('', Validators.required),
      'dtNascimento': new FormControl('', Validators.required),
      //rever naturalidade
      'naturalidade': new FormControl('', Validators.required),
      'nacionalidade': new FormControl('', Validators.required),
      'dtChegadaBrasil': new FormControl(''),
      'tpEstadoCivil': new FormControl('', Validators.required),
      'tpRegimeCasamento': new FormControl(''),

      //'nrDocumento': new FormControl('', Validators.required),
      //'nrDDD': new FormControl('', Validators.required),
      //'nrTelefone': new FormControl('', Validators.required),
      //'tipoTelefone': new FormControl('', Validators.required),
      //'stPrincipalTelefone': new FormControl('', Validators.required),
      'dsInformacaoAdicional': new FormControl('')





    });



  }

  // onSubmit(value: string) {
  //   this.submitted = true;
  //   console.log(value);
  //   console.log(this.telForm);




  // }

  verBloqueioCampos(e) {
    console.log("teste");
    this.pessoaForm.disable();
  }

  buscaPaisPorId(idPais: number): PaisSC {
    if (idPais) {
      let filtrados: PaisSC[] = <PaisSC[]>[];
      filtrados = this.paises.filter((p, i) => p.id == idPais);
      this.detalhePessoaFisica.idPaisNacionalidade = idPais;
      return filtrados[0];
    }
  }
  buscaRegimePorTp(tpRegimeCasamento: string): RegimeCasamento {
    if (tpRegimeCasamento) {
      let filtrados: RegimeCasamento[] = <RegimeCasamento[]>[];
      filtrados = this.listaDeRegimesDeCasamento.filter((r, i) => r.tpRegimeCasamento == tpRegimeCasamento);
      this.detalhePessoaFisica.tpRegimeCasamento = tpRegimeCasamento;
      return filtrados[0];
    }
  }
  buscaEstadoCivilPorTp(tpEstadoCivil: string): EstadoCivil {
    if (tpEstadoCivil) {
      let filtrados: EstadoCivil[] = <EstadoCivil[]>[];
      filtrados = this.listaDeEstadosCivis.filter((e, i) => e.tpEstadoCivil == tpEstadoCivil);
      this.pessoa.pessoaFisica.tpEstadoCivil = tpEstadoCivil;
      return filtrados[0];
    } else {
      return this.estadoCivil;
    }
  }

  converteObjParaDetalhePessoaFisica(dpf: DetalhePessoaFisica) {
    if (dpf) {
      this.detalhePessoaFisica.dsInformacaoAdicional = dpf.dsInformacaoAdicional;
      if (dpf.dtChegadaBrasil){
        this.detalhePessoaFisica.dtChegadaBrasil = new Date(dpf.dtChegadaBrasil);  
      }
      
      if (dpf.idPaisNacionalidade) {
        this.nacionalidade = this.buscaPaisPorId(dpf.idPaisNacionalidade);
      }
      /* falta o servico da suite fornecer o atributo tpEstadoCivil*/
      if (this.pessoaFisica.tpEstadoCivil == 'C' && (dpf.tpRegimeCasamento)) {
        this.regimeCasamento = this.buscaRegimePorTp(dpf.tpRegimeCasamento);
      }
      /*****/

      if (dpf.experienciasProfissionais){
          this.experiencias = dpf.experienciasProfissionais;
      }

    }
  }
  converteObjsParaPessoa(p) {
    if (p.pessoaFisica.dtNascimento) {
      this.dtNascimento = new Date(p.pessoaFisica.dtNascimento);
    }
    /* falta servico da suite */
    if (p.pessoaFisica.tpEstadoCivil) {
      this.estadoCivil = this.buscaEstadoCivilPorTp(p.pessoaFisica.tpEstadoCivil);
    }
    /********************** */
    this.pessoaDocumentos = p.pessoaDocumentos;
    this.pessoaEnderecos = p.pessoaEnderecos;
    this.pessoa = p;
    this.pessoaFisica = p.pessoaFisica;
    this.pessoaTelefones = p.pessoaTelefones;
    this.pessoaEmails = p.pessoaEmails;
  }

  buscarPessoaPorCpf(cpf: string) {

    let pessoas: Pessoa[] = <Pessoa[]>{};
    let pessoa: Pessoa = <Pessoa>{};
    let cpfComMascara: string;
    cpfComMascara = cpf;
    cpf = cpf.replace('.', '');
    cpf = cpf.replace('-', '');
    cpf = cpf.replace('/', '');

    this.ps.buscarPessoaPorCpf(cpf)
      .subscribe(
      dadosDoServidor => {
        this.cpfPesquisado = cpf;
        console.log(this.pessoaForm);

        pessoas = dadosDoServidor
        if (pessoas.length == 1) {
          pessoa = pessoas[0];
        }

        this.emitPesquisaCPF.emit(true);
        this.pesquisaCPF = false;
        this.converteObjsParaPessoa(pessoa);


        /** busca detalhePessoa fisica **/
        this.ps.buscarPorIdDetalhePessoaFisica(pessoa.id)
          .subscribe(
          dadosDoServidor => {
            this.converteObjParaDetalhePessoaFisica(dadosDoServidor);

          }
          );
      },
      errorDoServidor => {
        console.log(errorDoServidor);

      }

      );


  }

  atualizaPessoaDocumentos(lista) {
    this.pessoaDocumentos = lista;
  }
  atualizaPessoaEnderecos(lista) {
    this.pessoaEnderecos = lista;
  }
  atualizaPessoaTelefones(lista) {
    this.pessoaTelefones = lista;
  }
  atualizaPessoaEmails(lista) {
    this.pessoaEmails = lista;
  }
  atualizaExperiencias(lista) {
    this.experiencias = lista;
  }


  showSuccess() {
    this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Registro Salvo com Sucesso.' });
  }

  montaDetalhePessoaFisica(){
    this.detalhePessoaFisica.id = this.pessoa.id;
    this.detalhePessoaFisica.idPaisNacionalidade = this.nacionalidade.id;
    /*esse campo nao eh necessario no banco*/
    this.detalhePessoaFisica.stAtivo = "S";
    this.detalhePessoaFisica.tpRegimeCasamento = this.regimeCasamento.tpRegimeCasamento;
    this.experiencias.forEach((e, i ) => {
      e.idPEssoa = this.pessoa.id;
    });
    this.detalhePessoaFisica.experienciasProfissionais = this.experiencias;
    
  }

  salvarOuAtualizar() {

    
   

    let propPessoa: Pessoa = <Pessoa>{};
    /*pedir para o requisito incluir tipo de Endereco */
    let tipoEndereco: TipoEndereco = <TipoEndereco>{};
    tipoEndereco.id = 2;
    /***************/
    propPessoa.id = this.pessoa.id;
    this.pessoaEnderecos.forEach(
      (endereco, i) => {
        endereco.nrCep = endereco.nrCep.replace(".", "");
        endereco.nrCep = endereco.nrCep.replace("-", "");
        endereco.pessoa = propPessoa;
        endereco.tipoEndereco = tipoEndereco;
      }
    );

    this.pessoa.pessoaDocumentos = this.pessoaDocumentos;
    this.pessoa.pessoaEnderecos = this.pessoaEnderecos;
    this.pessoa.pessoaEmails = this.pessoaEmails;


    this.pessoaSCP.pessoa = this.pessoa;
    this.pessoaSCP.detalhePessoaFisica = this.detalhePessoaFisica;

    this.pessoa.tipoVinculo = null;
    this.pessoa.pessoaFisica.dtNascimento = this.dtNascimento;

    /* carantir que sera salvo o cpf pesquisado */
    //this.pessoa.pessoaFisica.nrCPF = this.cpfPesquisado;
    /* ***** */
    this.ps.salvarOuAtualizarPessoa(this.pessoa).subscribe(
      dadosDoServidor => {
        this.pessoaSalva = dadosDoServidor;
        
        this.montaDetalhePessoaFisica();
        
        this.ps.salvarOuAtualizarDetalhePessoaFisica(this.detalhePessoaFisica).subscribe(
          dadosDoServidor => {
            this.detalhePessoaFisicaSalva = dadosDoServidor;
            this.showSuccess();
          },
          errorDoServidor => {
            console.log(errorDoServidor);
          }
        );

      },
      errorDoServidor => {
        console.log(errorDoServidor);

      }
    );

  }



}
