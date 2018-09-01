
import { TipoDocumento } from './../interfaces/TipoDocumento';
import { TipoTelefone } from './../dominios/TipoTelefone';

import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Validators,FormControl,FormGroup,FormBuilder} from '@angular/forms';

import { PessoaTelefone } from './../dominios/PessoaTelefone';

import {MessageService} from 'primeng/api';
import { PessoaService } from './../pessoa.service';

@Component({
  selector: 'app-telefone',
  templateUrl: './telefone.component.html',
  styleUrls: ['./telefone.component.css'],
  
})
export class TelefoneComponent implements OnInit {

  listaDeTiposDeTelefones: any;
  tipoTelefonePadrao: TipoTelefone = <TipoTelefone>{"id":1,	"nmTipoTelefone":"Celular"};

  colunas: any[];
  @Input() lista: PessoaTelefone[] = [];
  telefone: PessoaTelefone = <PessoaTelefone>{};
  telefoneNovo: boolean;
  displayDialog: boolean;
  telefoneSelecionado: PessoaTelefone = <PessoaTelefone>{};
 
  @Output() emissor = new EventEmitter();

  
  
  
 

  telForm: FormGroup;
  
  constructor(private fb: FormBuilder, private messageService: MessageService, private ps: PessoaService) { }

  ngOnInit() {
    
    this.listaDeTiposDeTelefones = this.ps.retornaListaDeTiposDeTelefones();
    this.colunas = [
      { field: 'nrDdd', header: 'DDD (*)' },
      { field: 'nrTelefone', header: 'Telefone (*)' },
      { field: 'nmTipoTelefone', header: 'Tipo Tel. (*)' },
      { field: 'principal', header: 'Principal' },
      { field: 'controle', header: 'Controle' }
    ];

  


    
    this.telForm = this.fb.group({
      
      
      //'nrDdd': new FormControl('', Validators.compose([Validators.required, Validators.min(2),Validators.max(2),Validators.pattern('[1-9]{2}')])),
      'nrDdd': new FormControl('', Validators.compose([Validators.required, Validators.pattern('[1-9]{2}')])),
      'nrTelefone': new FormControl('', Validators.compose([Validators.required, Validators.minLength(8),Validators.maxLength(10)])),
      'tipoTelefone': new FormControl('', Validators.required),
      'stPrincipal': new FormControl('') 
      
      
  });
  




  }

  mostaraDialogoParaAdicionar() {
    this.telefoneNovo = true;
    this.telefone = <PessoaTelefone>{};
    this.displayDialog = true;
    this.telefone.tipoTelefone = this.tipoTelefonePadrao;
    this.telefone.stPrincipal = "S";
    
  }

  salva() {
    let lista = this.lista;
    if ( this.telefone.stPrincipal == "S"){
        lista.forEach((tel, i) => {
        tel.stPrincipal = "N";
        
      });
    }
    
    if (this.telefoneNovo)
      lista.push(this.telefone);
    else
      lista[this.lista.indexOf(this.telefoneSelecionado)] = this.telefone;

    this.lista = lista;
    this.telefone = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
    
  }

  

  handleChange(e) {
   
    let valor = e.checked;
    if (valor) {
        this.telefone.stPrincipal = "S";
    }else{
        this.telefone.stPrincipal = "N";
    }
    
    
  }

  retValorConvertidoStPrincipal() {
    
    if (this.telefone.stPrincipal == "S"){
        return true;
     }else{
       return false;
     }
  }

  exclui() {
    let index = this.lista.indexOf(this.telefoneSelecionado);
    this.lista = this.lista.filter((val, i) => i != index);
    this.telefone = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
  }

  selectEdicao(event) {
    this.telefoneNovo = false;
    this.telefone = this.clonaTelefone(event.data);
    this.displayDialog = true;
  }
  
  clonaTelefone(c: PessoaTelefone): PessoaTelefone {
    let telefone = <PessoaTelefone>{};
    for (let prop in c) {
      telefone[prop] = c[prop];
    }
    return telefone;
  }

  deleta(telefone) {
    let index = this.lista.indexOf(telefone);
    this.lista = this.lista.filter((val, i) => i != index);
    this.telefone = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
  }
  
  

  

}
