import { PessoaService } from './../pessoa.service';
import { ExperienciaProfissional } from './../dominios/ExperienciaProfissional';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  

  
  @Output() emissor = new EventEmitter();
  experienciaForm: FormGroup;

  @Input() lista =  new Array;
  
  
  

  colunas: any[];
  experienciaNovo: boolean;
  displayDialog: boolean;
  experiencia: ExperienciaProfissional = <ExperienciaProfissional>{};
  experienciaSelecionado: ExperienciaProfissional = <ExperienciaProfissional>{};
  
  
  constructor(private fb: FormBuilder, private ps: PessoaService) {

  }

  ngOnInit() {
    
    
    this.experiencia.dtInicioCargo = new Date();
    this.experiencia.dtFimCargo = new Date();
    console.log(this.experiencia.dtFimCargo);
    

    this.colunas = [
      { field: 'nmEmpresa', header: 'Empresa (*)' },
      { field: 'nmCargo', header: 'Cargo/Função(*)' },
      { field: 'dtInicioCargo', header: 'Data Início' },
      { field: 'dtFimCargo', header: 'Data Fim' },
      { field: 'controle', header: 'Controle' }
    ];

    this.experienciaForm = this.fb.group({
      'nmEmpresa': new FormControl({ value: this.experiencia.nmEmpresa }, Validators.required),
      'nmCargo': new FormControl({value:this.experiencia.nmCargo}, Validators.required),
      'dtInicioCargo': new FormControl('', Validators.required),
      'dtFimCargo': new FormControl('', Validators.required),
    });

    


  }



  salva() {
    let lista = this.lista;
    
    if (this.experienciaNovo)
      lista.push(this.experiencia);
    else
      lista[this.lista.indexOf(this.experienciaSelecionado)] = this.experiencia;

    this.lista = lista;
    this.experiencia = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
  }

  

  mostaraDialogoParaAdicionar() {
    this.experienciaNovo = true;
    this.experiencia = new ExperienciaProfissional();
    this.displayDialog = true;
    

  }

 
  exclui() {
    let index = this.lista.indexOf(this.experienciaSelecionado);
    this.lista = this.lista.filter((val, i) => i != index);
    this.experiencia = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
    
  }
  selectEdicao(event) {
    this.experienciaNovo = false;
    this.experiencia = this.clonaEndereco(event.data);
    this.displayDialog = true;
  }
  clonaEndereco(c: ExperienciaProfissional): ExperienciaProfissional {
    let experiencia = <ExperienciaProfissional>{};
    for (let prop in c) {
      experiencia[prop] = c[prop];
    }
    return experiencia;
  }

  deleta(experiencia) {
    let index = this.lista.indexOf(experiencia);
    this.lista = this.lista.filter((val, i) => i != index);
    this.experiencia = null;
    this.displayDialog = false;
    this.emissor.emit(this.lista);
    
  }

  
}
