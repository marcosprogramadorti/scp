import { PessoaEmail } from './../dominios/PessoaEmail';
import { DetalhePessoaFisica } from './../dominios/DetalhePessoaFisica';
import { PessoaEndereco } from './../dominios/PessoaEndereco';
import { PessoaFisica } from './../dominios/PessoaFisica';
import { Component, OnInit, Output,Input, EventEmitter } from '@angular/core';
import {Validators,FormControl,FormGroup,FormBuilder} from '@angular/forms';

import { SelectItem } from 'primeng/api';
import { MessageService } from 'primeng/api';

import { Pais } from './../interfaces/Pais';
import { PessoaSCP } from './../dominios/PessoaSCP';
import { Pessoa } from './../dominios/Pessoa';
import { PessoaService } from './../pessoa.service';
import { PessoaTelefone } from './../interfaces/PessoaTelefone';



@Component({
  selector: 'app-form-pessoa',
  templateUrl: './form-pessoa.component.html',
  styleUrls: ['./form-pessoa.component.css']
})
export class FormPessoaComponent implements OnInit {

  //SelectItem API with label-value pairs
  
  @Output() emitePessoaEndereco: EventEmitter<PessoaEndereco[]> = new EventEmitter();

  pessoa:Pessoa = <Pessoa>{};
  pessoaFisica:PessoaFisica = <PessoaFisica>{};
  pessoaEnderecos:PessoaEndereco[] = <PessoaEndereco[]>[];
  pessoaTelefones: PessoaTelefone[] = <PessoaTelefone[]>[];
  pessoaEmails: PessoaEmail[] = <PessoaEmail[]>[];
  detalhePessoaFisica: DetalhePessoaFisica = <DetalhePessoaFisica>{};
  dtNascimento:Date;
  
  
  pessoaSCP: PessoaSCP;
  paises:any;
  listaDeEstadosCivis:any;
  ufs:any;
  listaDeRegimesDeCasamento:any;
  nacionalidadePadrao: Pais = <Pais>{};

  pessoaForm: FormGroup;
  telForm: FormGroup;
  submitted: boolean;
  naturalidade: Pais = <Pais>{};
  
  

  
 

  constructor(private fb: FormBuilder, private ps: PessoaService) {}
  
  ngOnInit() {
    
    this.paises = this.ps.retornaListaDePais();
    this.listaDeEstadosCivis = this.ps.retornaListaDeEstadosCivis();
    this.ufs = this.ps.retornaListaDeUFs();
    this.listaDeRegimesDeCasamento =  this.ps.retornaListaDeRegimesDeCasamento();

    this.nacionalidadePadrao = { "gentilico" : "brasileira",
       "nome_pais" : "Brasil",
       "nome_pais_int" : "Brazil",
       "sigla" : "BR"
       };

       this.pessoaForm = this.fb.group({
        'nrCpf': new FormControl('', Validators.required),
        'nmPessoa': new FormControl('', Validators.required),
        'dtNascimento': new FormControl('', Validators.required),
        //rever naturalidade
        'naturalidade': new FormControl('', Validators.required),
        'nacionalidade': new FormControl('', Validators.required),
        'dtChegadaBrasil': new FormControl('', Validators.required),
        'tpEstadoCivil': new FormControl('', Validators.required),
        'tpRegimeCasamento': new FormControl('', Validators.required),
        
        'nrDocumento': new FormControl('', Validators.required),
        'nrDDD': new FormControl('', Validators.required),
        'nrTelefone': new FormControl('', Validators.required),
        'tipoTelefone': new FormControl('', Validators.required),
        'stPrincipalTelefone': new FormControl('', Validators.required) 
        
     
        
        
    });
    


  }

  onSubmit(value: string) {
    this.submitted = true;
    console.log(value);
    console.log(this.telForm);
    
            
    
    
  }

  
  reciverFeedback(respostaFilho) {
    //this.pessoaTelefones = respostaFilho;
    console.log('Foi emitido o evento e chegou no pai >>>> ', this.pessoaTelefones);
  }
  

  buscarPessoaPorCpf(cpf: string) {

    let pessoas: Pessoa[] =  <Pessoa[]>{};
    let pessoa: Pessoa =  <Pessoa>{};
    let cpfComMascara: string;
    cpfComMascara = cpf;
    cpf = cpf.replace('.','');
    cpf = cpf.replace('-','');
    cpf = cpf.replace('/','');
    
    this.ps.buscarPessoaPorCpf(cpf)
    .subscribe( 
      dadosDoServidor => { 
        pessoas = dadosDoServidor
        if (pessoas.length==1){
          pessoa = pessoas[0];
        }
        this.dtNascimento = new Date( pessoa.pessoaFisica.dtNascimento);
        this.pessoaEnderecos = pessoa.pessoaEnderecos;
        this.pessoa = pessoa;
        this.pessoaFisica = pessoa.pessoaFisica;
        this.pessoaTelefones = pessoa.pessoaTelefones;
        
      },
      errorDoServidor => {
            console.log(errorDoServidor);
            
      }
    
    );

    this.emitePessoaEndereco.emit(this.pessoaEnderecos);
  }
  


}
