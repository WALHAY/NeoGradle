local neogradle = {}

local config = {}

neogradle.config = config

local file = io.open("walhaynigga.txt", "a")

local on_stdout = function(chan, data, name)
    -- file:write(vim.inspect(data))
end

neogradle.setup = function(args)
    -- local exec_path = "/Users/walhay/projects/NeoGradle/build/install/NeoGradle/bin/NeoGradle"
    -- local job_id = vim.fn.jobstart({ "sh", exec_path }, { rpc = true, on_stderr = on_stdout, on_stdout = on_stdout })

    vim.api.nvim_create_user_command("Nigger", function() print(vim.g.gradle.job_id) end, {})
    vim.api.nvim_create_user_command("Zigger", function() vim.rpcrequest(vim.g.gradle.job_id, "gradle", "nigga") end, {})
end

return neogradle
