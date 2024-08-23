call extend(g:, {'gradle': {}}, 'keep')
call extend(g:gradle, {'job_id': 0}, 'keep')

let s:bin = expand('<sfile>:p:h')..'/../build/install/NeoGradle/bin/neogradle'


function! s:on_stderr(chan_id, data, name)
	echom printf('%s: %s', a:name, string(a:data))
endfunction


function! s:connect()
	let l:job_id = s:initRpc(g:gradle.job_id)

	if l:job_id == 0
		echoerr "Gradle: cannot start RPC process"
	elseif l:job_id == -1
		echoerr "Gradle: RPC process is not executable"
	else
		" Mutate our job Id variable to hold the channel ID
		let g:gradle.job_id = l:job_id
	endif
endfunction

function! s:initRpc(job_id)
	if a:job_id == 0
		let l:opts = {'rpc': v:true, 'on_stderr': funcref('s:on_stderr')}
		let jobid = jobstart(['sh', s:bin], l:opts)
		return jobid
	else
		return a:job_id
	endif
endfunction

call s:connect()

command! GradleNoOp :echo rpcrequest(g:gradle.job_id, 'gradle', 'no-op')
