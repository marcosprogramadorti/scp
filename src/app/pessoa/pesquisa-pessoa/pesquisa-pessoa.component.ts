import { PessoaFisica } from './../dominios/PessoaFisica';
import { Pessoa } from './../dominios/Pessoa';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pesquisa-pessoa',
  templateUrl: './pesquisa-pessoa.component.html',
  styleUrls: ['./pesquisa-pessoa.component.css']
})
export class PesquisaPessoaComponent implements OnInit {
  pessoa:Pessoa = <Pessoa>{};
  pessoaFisica:PessoaFisica = <PessoaFisica>{};
  ativo:boolean = true;
  tipoDeVinculo:number[] = [];
  colunas: any[];

  constructor() { }

  ngOnInit() {
    this.colunas = [
      { field: 'acao', header: 'Ações',width: 300 },
      { field: 'nmPessoa', header: 'Pessoa',width: 100 },
      { field: 'cpfECnpj', header: 'CPF/CNPJ' ,width: 20},
      { field: 'unidade', header: 'Unidade',width: 100 },
      { field: 'tipoVinculo', header: 'Tipo de Vínculo' ,width: 100},
      { field: 'ativo', header: 'Ativo' ,width: 50}
    ];
  }

}
