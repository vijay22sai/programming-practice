def modPow(x, r, m)
  y = r
  z = x
  v = 1
  while y > 0
    u = y % 2
    t = y / 2
    if u == 1
      v = (v * z) % m
    end
    z = z * z % m
    y = t
  end
  return v
end

def miller_rabin_pass(a, n)
  #compute s and d

  d = n - 1
  s = 0
  while d % 2 == 0 do
    d >>= 1
    s += 1
  end

  a_to_power = modPow(a, d, n)
  if a_to_power == 1
    return true
  end
  for i in 0...s do
    if a_to_power == n - 1
      return true
    end
    a_to_power = (a_to_power * a_to_power) % n
  end
  return (a_to_power == n - 1)
end

def miller_rabin(n)
  if n==1
   return false
  end
  if n==2
    return true
  end
  k = 20
  for i in 0...k do
    a = 0
    while a == 0
      a = rand(n)
    end
    if (!miller_rabin_pass(a, n))
      return false
    end
  end
  return true
end

def pr_primes(m,n)
  (m..n).each{|p|
    if miller_rabin(p)
      puts p
    end
  }
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

#puts miller_rabin(91)

print_primes
