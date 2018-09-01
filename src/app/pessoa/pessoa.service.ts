import { ExperienciaProfissional } from './dominios/ExperienciaProfissional';
import { PaisSC } from './dominios/PaisSC';
import { Pais } from './interfaces/Pais';
import { DetalhePessoaFisica } from './dominios/DetalhePessoaFisica';
import { Pessoa } from './dominios/Pessoa';
import { Logradouro } from './dominios/Logradouro';
import { Localidade } from './dominios/Localidade';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';


import * as fileEstadoCivil from './constantes/estado-civil.json';
import * as filePais from './constantes/pais.json';
import * as fileUFs from './constantes/ufs.json';
import * as fileRegimeCasamento from './constantes/regime-casamento.json';
import * as fileTipoTelefone from  './constantes/tipo-telefone.json';
import * as fileTipoDocumento from './constantes/tipo-documento.json';


import { TipoLogradouro } from './dominios/TipoLograduro';
import { Uf } from './dominios/Uf';


@Injectable({
  providedIn: 'root'
})
export class PessoaService {
  
  /*estadoCivil = require('./../constantes/estado-civil.json');
  pais:any; = require('./../constantes/pais.json');
  estadoCivil:any;
  ufs:any; = require('./../constantes/ufs.json');
  regimeCasamento:any; = require('./../constantes/regime-casamento.json');*/

  
  configUrl = 'assets/config.json';

  listaDePais  = (<any>filePais).listaDePais;
  listaDeEstadosCivis = (<any>fileEstadoCivil).listaDeEstadosCivis;
  listaDeUFs = (<any>fileUFs).listaDeUFs;
  listaDeRegimesDeCasamento = (<any>fileRegimeCasamento).listaDeRegimesDeCasamento;
  listaDeTiposDeTelefones = (<any>fileTipoTelefone).listaDeTiposDeTelefones;
  listaDeTiposDeDocumentos = (<any>fileTipoDocumento).listaDeTiposDeDocumentos;

  
  getHeaders() {
    let headers = new HttpHeaders();
    headers = headers.append("Content-Type", "application/json");
    return headers;
  }

  

  retornaLocalidadePorId(id) :Observable<Localidade> {
    return this.http.get<Localidade>('http://localhost:8080/suiteCorporativa/localidadePorId/'+id);
  }

  retornaListaDeTiposDeLogradouros() :Observable<TipoLogradouro[]> {
    return this.http.get<TipoLogradouro[]>('http://localhost:8080/suiteCorporativa/listarTiposLogradouro');
  }
  retornaListaUF() :Observable<Uf[]> {
    return this.http.get<Uf[]>('http://localhost:8080/suiteCorporativa/ufs');
  }
  retornaLogradouroPorCEP(cep:string) :Observable<Logradouro> {
    return this.http.get<Logradouro>('http://localhost:8080/suiteCorporativa/logradouroPorCep/'+cep);
  }
  retornaListaDeLocalidades(uf:Uf) : Observable<Localidade[]>  {
    
    return this.http.post<Localidade[]>('http://localhost:8080/suiteCorporativa/localidadesPorUf',JSON.stringify(uf), {
      headers  : this.getHeaders()
    });
  }

  retornaListaDePessoas(pessoa:Pessoa) : Observable<Pessoa[]>  {
    return this.http.post<Pessoa[]>('http://localhost:8080/suiteCorporativa/pessoa/pesquisa',JSON.stringify(pessoa), {
      headers  : this.getHeaders()
    });
  }

  buscarPorIdDetalhePessoaFisica(id:number) :Observable<DetalhePessoaFisica> {
    return this.http.get<DetalhePessoaFisica>('http://localhost:8080/detalhePessoaFisica/'+id);
  }
  buscarPorIdExperienciaProfissional(id:number) :Observable<ExperienciaProfissional> {
    return this.http.get<ExperienciaProfissional>('http://localhost:8080/experienciaProfissional/'+id);
  }
  buscarPessoaPorCpf(cpf:string) :Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>('http://localhost:8080/suiteCorporativa/pessoas/buscarPessoaPorCpf/'+cpf);
  }
  buscarPessoaPorCnpj(cnpj:string) :Observable<Pessoa[]> {
    return this.http.get<Pessoa[]>('http://localhost:8080/suiteCorporativa/pessoas/buscarPessoaPorCnpj/'+cnpj);
  }

  constructor( private http: HttpClient ) { }

  getConfig() {
    return this.http.get(this.configUrl);
  }

  retornaListaDeEstadosCivis() {
    return this.listaDeEstadosCivis;
  } 
  
  retornaListaDePaises(){
    return this.listaDePais;
  } 
  retornaListaDePaisesSC() :Observable<PaisSC[]> {
    return this.http.get<PaisSC[]>('http://localhost:8080/paisNacionalidade/paises');
  }
  
  retornaListaDeUFs(){
    return this.listaDeUFs;
  }
  retornaListaDeRegimesDeCasamento(){
    return this.listaDeRegimesDeCasamento;
  }  

  retornaListaDeTiposDeTelefones(){
    return this.listaDeTiposDeTelefones;
  }
  retornaListaDeTiposDeDocumentos(){
    return this.listaDeTiposDeDocumentos;
  }

  salvarOuAtualizarPessoa(pessoa:Pessoa) : Observable<Pessoa>  {
    return this.http.post<Pessoa>('http://localhost:8080/suiteCorporativa/pessoas/salvarOuAtualizar',pessoa, {
      headers  : this.getHeaders()
    });
  }
  salvarOuAtualizarExperienciaProfissional(experienciaProfissional:ExperienciaProfissional) : Observable<ExperienciaProfissional>  {
    return this.http.post<ExperienciaProfissional>('http://localhost:8080/experienciaProfissional',experienciaProfissional, {
      headers  : this.getHeaders()
    });
  }
  salvarOuAtualizarDetalhePessoaFisica(detalhePessoaFisica:DetalhePessoaFisica) : Observable<DetalhePessoaFisica>  {
    return this.http.post<DetalhePessoaFisica>('http://localhost:8080/detalhePessoaFisica',detalhePessoaFisica, {
      headers  : this.getHeaders()
    });
  }

  salvaPessoaSCP( ){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })

    };
  }
  
}
