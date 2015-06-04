
#TLE
def generate_primes1(m,n)
  if m==2
    primes = [2,3]
  elsif m==3
    primes = [3]
  else
    primes = []
  end
  (m..n).each{|num|
    i=2
    while i*i<=num
      if(num%i==0)
        flag = 0
        break
      else
        flag = 1
      end
      i=i+1
    end
    if flag == 1
      primes << num
    end
  }
  primes
end

def pr_primes(m,n)
  (m..n).each{|p|
    if prime?(p)
      puts p
    end
  }
end

def prime?(p)
  (10000).times{
    a = rand(1...p)
    #z = a**(p-1)
    if(a**(p-1)%p!=1)
      return false
    end
  }
  return true
end

def print_primes
  t = STDIN.gets.to_i
  arr = t.times.map{
    line = STDIN.gets
    line.split(' ').map{|s| s.to_i}
  }
  arr.each{|ar|
    m,n = ar[0],ar[1]
    pr_primes(m,n)
    puts "\n"
  }
end

print_primes
