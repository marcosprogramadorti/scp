import { PessoaEmail } from './../dominios/PessoaEmail';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Validators,FormControl,FormGroup,FormBuilder} from '@angular/forms';

import {MessageService} from 'primeng/api';
import { PessoaService } from './../pessoa.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

  colunas: any[];
  @Input() lista: PessoaEmail[] = [];
  email: PessoaEmail = <PessoaEmail>{};
  emailNovo: boolean;
  displayDialog: boolean;
  emailSelecionado: PessoaEmail = <PessoaEmail>{};
 
  @Output() emissor = new EventEmitter();
  

  
  
  emailForm: FormGroup;

  constructor(private fb: FormBuilder, private messageService: MessageService, private ps: PessoaService) { }

  ngOnInit() {
    this.colunas = [
      { field: 'dsEmail', header: 'E-mail(*)' },
      { field: 'principal', header: 'Principal' },
      { field: 'controle', header: 'Controle' }
    ];

    let email = <PessoaEmail>{};
    
    this.emailForm = this.fb.group({
      'dsEmail': new FormControl('', Validators.compose([Validators.required, Validators.email])),
      'stPrincipal': new FormControl('', Validators.required) 
   });

  }

  mostaraDialogoParaAdicionar() {
    this.emailNovo = true;
    this.email = <PessoaEmail>{};
    this.displayDialog = true;
    this.email.stPrincipal = "S";
  }

  salva() {
    let lista = this.lista;
    if ( this.email.stPrincipal == "S"){
        lista.forEach((email, i) => {
          email.stPrincipal = "N";
        
      });
    }
    
    if (this.emailNovo)
      lista.push(this.email);
    else
      lista[this.lista.indexOf(this.emailSelecionado)] = this.email;

    this.lista = lista;
    this.email = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
    
  }

  

  handleChange(e) {
   
    let valor = e.checked;
    if (valor) {
        this.email.stPrincipal = "S";
    }else{
        this.email.stPrincipal = "N";
    }
    
    
  }

  retValorConvertidoStPrincipal() {
    
    if (this.email.stPrincipal == "S"){
        return true;
     }else{
       return false;
     }
  }

  exclui() {
    let index = this.lista.indexOf(this.emailSelecionado);
    this.lista = this.lista.filter((val, i) => i != index);
    this.email = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
  }

  selectEdicao(event) {
    this.emailNovo = false;
    this.email = this.clonaTelefone(event.data);
    this.displayDialog = true;
  }
  
  clonaTelefone(c: PessoaEmail): PessoaEmail {
    let email = <PessoaEmail>{};
    for (let prop in c) {
      email[prop] = c[prop];
    }
    return email;
  }

  deleta(emaiil) {
    let index = this.lista.indexOf(emaiil);
    this.lista = this.lista.filter((val, i) => i != index);
    this.email = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
  }

}
