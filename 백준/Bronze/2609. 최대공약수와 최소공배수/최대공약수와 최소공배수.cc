#include <iostream>

using namespace std;

int gcd(int a,int b){
    int r;
    for(;b>0;){
        r=a%b;
        a=b;
        b=r;
    }
    return a;
}

int main(){
    int n,m,g,c,tmp;
    cin>>n>>m;
    g = gcd(max(n,m),min(n,m));
    c= (n/g) * m; 
    cout<<g<<'\n'<<c;
}