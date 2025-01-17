#include <iostream>
#include <stack>
using namespace std;

stack <char> L;
stack <char> D;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    char c;
    int n;
    string s;
    cin>>s>>n;

    for(int i=0;i<s.length();i++){
        L.push(s[i]);
    }

    for(int i=0;i<n;i++){
        cin>>c;
        if(c=='L'){
            if(!L.empty()) {
                D.push(L.top());
                L.pop();
            }
        }
        else if(c=='D'){
            if(!D.empty()) {
                L.push(D.top());
                D.pop();
            }
        }
        else if(c=='B'){
            if(!L.empty()) L.pop();
        }
        else{
            cin>>c;
            L.push(c);
        }
    }
    
    for(;!L.empty();){
        D.push(L.top());
        L.pop();
    }

    for(;!D.empty();){
        cout<<D.top();
        D.pop();
    }
}