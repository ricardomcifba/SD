
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   cadDLL.h
 * Author: Ricardo
 *

 */

#ifdef BUILD_DLL
 #define CADDLL __declspec(dllexport)
#else
 #define CADDLL __declspec(dllimport)
#endif

struct Cadastro{
    char nome[10];
    char matricula[10];
    char curso[10];
}typedef cad;



CADDLL void salvarAluno(char *nome,char *matricula,char *curso);
CADDLL cad recuperarAluno(char *nome);
CADDLL void apagaAluno (char *nome);



