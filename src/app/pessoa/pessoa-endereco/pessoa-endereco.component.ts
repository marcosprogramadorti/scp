import { Logradouro } from './../dominios/Logradouro';
import { PessoaService } from './../pessoa.service';
import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';

import { PessoaEndereco } from './../dominios/PessoaEndereco';
import { Localidade } from './../dominios/Localidade';
import { Uf } from './../dominios/Uf';
import { TipoLogradouro } from './../dominios/TipoLograduro';



import { Validators, FormControl, FormGroup, FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-pessoa-endereco',
  templateUrl: './pessoa-endereco.component.html',
  styleUrls: ['./pessoa-endereco.component.css']
})
export class PessoaEnderecoComponent implements OnInit {

  @Output() respostaEnderecos = new EventEmitter();
  //pessoaEnderecos: PessoaEndereco[] = [];

  pesquisaCEP: boolean = false;

  enderecoForm: FormGroup;

  @Input() lista:  PessoaEndereco[] = [];
   
  
  

  colunas: any[];
  enderecoNovo: boolean;
  displayDialog: boolean;
  endereco: PessoaEndereco = <PessoaEndereco>{};
  enderecoSelecionado: PessoaEndereco = <PessoaEndereco>{};
  listaDeTiposDeLogradouros: TipoLogradouro[] = [];
  listaDeUfs: Uf[] = [];
  listaDeLocalidades: any;
  uf: Uf;
  localidadePadrao: Localidade = <Localidade>{ "id": 1, "nmLocalidade": "Selecione uma Cidade" };


  constructor(private fb: FormBuilder, private ps: PessoaService) {

  }

  ngOnInit() {
    

    this.ps.retornaListaDeTiposDeLogradouros()
      .subscribe(dadosDoServidor => {
      this.listaDeTiposDeLogradouros = dadosDoServidor
      });
    this.ps.retornaListaUF()
      .subscribe(dadosDoServidor => {
      this.listaDeUfs = dadosDoServidor
      });







    this.colunas = [
      { field: 'nrCep', header: 'CEP (*)' },
      { field: 'tipoLogradouro', header: 'Tipo de  Logradouro (*)' },
      { field: 'uf', header: 'UF' },
      { field: 'localidade', header: 'Cidade' },
      { field: 'dsLogradouro', header: 'Logradouro' },
      { field: 'nrLogradouro', header: 'Número' },
      { field: 'dsComplemento', header: 'Complemento' },
      { field: 'nmBairro', header: 'Bairro' },
      { field: 'principal', header: 'Principal' },
      { field: 'controle', header: 'Controle' }
    ];

    this.enderecoForm = this.fb.group({

      'nrCep': new FormControl({ value: '' }, Validators.compose([Validators.required, Validators.pattern('^[0-9]{2}.[0-9]{3}-[0-9]{3}$')])),
      'tipoLogradouro': new FormControl('', Validators.required),
      'localidade': new FormControl({ value: '' }),
      'dsLogradouro': new FormControl({ value: '', disabled: true }, Validators.required),
      'dsComplemento': new FormControl({ value: '', disabled: true }),
      'nmBairro': new FormControl({ value: '', disabled: true }),
      'stPrincipal': new FormControl(''),
      'uf': new FormControl(''),
      'nrLogradouro': new FormControl({ value: '', disabled: true }),


    });

    this.endereco.localidade = this.localidadePadrao;


  }




  atualizaListaDeLocalidades() {

    this.ps.retornaListaDeLocalidades(this.uf)
      .subscribe(dadosDoServidor => {
      this.listaDeLocalidades = dadosDoServidor



      });
  }


  salva() {
    let lista = this.lista;
    if (this.endereco.stPrincipal == "S") {
      lista.forEach((endereco, i) => {
        endereco.stPrincipal = "N";
      });
    }
    if (this.enderecoNovo)
      lista.push(this.endereco);
    else
      lista[this.lista.indexOf(this.enderecoSelecionado)] = this.endereco;

    this.lista = lista;
    this.endereco = null;
    this.displayDialog = false;
    this.respostaEnderecos.emit(this.lista);
  }

  handleChange(e) {

    let valor = e.checked;
    if (valor) {
      this.endereco.stPrincipal = "S";
    } else {
      this.endereco.stPrincipal = "N";
    }


  }

  mostaraDialogoParaAdicionar() {
    this.enderecoNovo = true;
    this.endereco = new PessoaEndereco();
    this.displayDialog = true;
    this.pesquisaCEP = false;

  }

  retValorConvertidoStPrincipal() {

    if (this.endereco.stPrincipal == "S") {
      return true;
    } else {
      return false;
    }
  }

  exclui() {
    let index = this.lista.indexOf(this.enderecoSelecionado);
    this.lista = this.lista.filter((val, i) => i != index);
    this.endereco = null;
    this.displayDialog = false;
    this.respostaEnderecos.emit(this.lista);
    this.pesquisaCEP = false;
  }
  selectEdicao(event) {
    this.enderecoNovo = false;
    this.endereco = this.clonaEndereco(event.data);
    this.displayDialog = true;
  }
  clonaEndereco(c: PessoaEndereco): PessoaEndereco {
    let endereco = <PessoaEndereco>{};
    for (let prop in c) {
      endereco[prop] = c[prop];
    }
    return endereco;
  }

  deleta(endereco) {
    let index = this.lista.indexOf(endereco);
    this.lista = this.lista.filter((val, i) => i != index);
    this.endereco = null;
    this.displayDialog = false;
    this.respostaEnderecos.emit(this.lista);
    this.pesquisaCEP = false;
  }

  ufPorid(id): Uf {
    let uf: Uf = <Uf>{}
    let filtrados: Uf[] = <Uf[]>{}

    filtrados = this.listaDeUfs.filter((val, i) => id == val.id);
    uf = filtrados[0];
    return uf;
  }
  tipoDeLogradouroPorid(id): TipoLogradouro {
    let tipoLogradouro: TipoLogradouro = <TipoLogradouro>{}
    let filtrados: TipoLogradouro[] = <TipoLogradouro[]>{}
    filtrados = this.listaDeTiposDeLogradouros.filter((val, i) => id == val.id);
    tipoLogradouro = filtrados[0];
    return tipoLogradouro;
  }
  buscaLogradouroPorCEP(cep: string) {
    let logradouro: Logradouro = <Logradouro>{};
    let localidade: Localidade = <Localidade>{};
    let cepComMascara: string;
    cepComMascara = cep;
    cep = cep.replace('.', '');
    cep = cep.replace('-', '');

    this.ps.retornaLogradouroPorCEP(cep)
      .subscribe(dadosDoServidor => {
        logradouro = dadosDoServidor
        if (logradouro.idLocalidade != null) {
          this.ps.retornaLocalidadePorId(logradouro.idLocalidade).subscribe(dadosDoServidor => {
            localidade = dadosDoServidor

            this.endereco.nrCep = cepComMascara;

            this.endereco.nmBairro = logradouro.nmBairroInicial;
            this.endereco.dsLogradouro = logradouro.dsLogradouro;
            this.uf = this.ufPorid(logradouro.idUf);
            this.atualizaListaDeLocalidades();
            this.endereco.localidade = localidade;
            this.endereco.tipoLogradouro = this.tipoDeLogradouroPorid(logradouro.idTipoLogradouro);
            //this.endereco.logradouro = logradouro;

            this.pesquisaCEP = true;
            this.verBloqueioCampo();



          });
        }

      });
  }

  verBloqueioCampo() {
    if (this.pesquisaCEP && this.endereco.dsLogradouro == null) {
      this.enderecoForm.controls['dsLogradouro'].enable();
    } else {
      this.enderecoForm.controls['dsLogradouro'].disable();
    }
    if (this.pesquisaCEP && this.endereco.nmBairro == null) {
      this.enderecoForm.controls['nmBairro'].enable();
    } else {
      this.enderecoForm.controls['nmBairro'].disable();
    }
    if (this.pesquisaCEP && this.endereco.nrLogradouro == null) {
      this.enderecoForm.controls['nrLogradouro'].enable();
    } else {
      this.enderecoForm.controls['nrLogradouro'].disable();
    }
    if (this.pesquisaCEP && this.endereco.dsComplemento == null) {
      this.enderecoForm.controls['dsComplemento'].enable();
    } else {
      this.enderecoForm.controls['dsComplemento'].disable();
    }

  }


}


