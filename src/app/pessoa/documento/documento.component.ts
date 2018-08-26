import { PessoaService } from './../pessoa.service';

import { Component, OnInit, EventEmitter } from '@angular/core';
import {Validators,FormControl,FormGroup,FormBuilder} from '@angular/forms';

import { PessoaDocumento } from './../interfaces/PessoaDocumento';
import { TipoDocumento } from './../interfaces/TipoDocumento';

@Component({
  selector: 'app-documento',
  templateUrl: './documento.component.html',
  styleUrls: ['./documento.component.css']
})
export class DocumentoComponent implements OnInit {

  
  listaTipoDocumento: TipoDocumento[] = <TipoDocumento[]>[];
  mostraDialogo: boolean;
  pessoaDocumento: PessoaDocumento = <PessoaDocumento>{};
  tipoDocumento: TipoDocumento = <TipoDocumento>{};
  pessoaDocumentoSelecionada: PessoaDocumento = <PessoaDocumento>{};
  novaPessoaDocumento: boolean;
  lista: PessoaDocumento[] = [];
  colunas: any[];

  public docForm: FormGroup;

  constructor(private fb: FormBuilder, private ps: PessoaService) { }

  ngOnInit() {  

    this.listaTipoDocumento = this.ps.retornaListaDeTiposDeDocumentos();
    this.docForm = this.fb.group({
      
      'tipoDocumento': new FormControl('', Validators.required),
      'nrDocumento': new FormControl('', Validators.required)
      
  });

  }

  mostaraDialogoParaAdicionar() {
    
    this.novaPessoaDocumento = true;
    this.pessoaDocumento = <PessoaDocumento>{};
    this.mostraDialogo = true;


  }
  salva() {

    if (this.novaPessoaDocumento) {
      this.lista.push(this.pessoaDocumento);
    }
    else {
      this.lista[this.lista.indexOf(this.pessoaDocumentoSelecionada)] = this.pessoaDocumento;
    }

    this.pessoaDocumento = null;
    this.mostraDialogo = false;


  }

  deleta(documento) {
    let index = this.lista.indexOf(documento);
    this.lista = this.lista.filter((val, i) => i != index);
    this.pessoaDocumento = null;
    this.mostraDialogo = false;
  }
  edita(documento) {
    
    this.pessoaDocumentoSelecionada = documento;
    this.pessoaDocumento = documento;
    this.mostraDialogo = true;
  }

  
  onRowSelect(event) {

    console.log(this.pessoaDocumento);

    // this.novaPessoaDocumento = false;
    // this.pessoaDocumento = this.copiaPessoaDocumento(event.data);
    // this.mostraDialogo = true;
    // console.log(this.pessoaDocumento);

  }

  copiaPessoaDocumento(pd: PessoaDocumento): PessoaDocumento {
    let pessoaDocumento = <PessoaDocumento>{};
    for (let prop in pd) {
      pessoaDocumento[prop] = pd[prop];
    }
    return pessoaDocumento;
  }

  




}
